package com.example.uber.Services;

import com.example.uber.Models.Review;
import com.example.uber.Repositories.ReviewRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ReviewServiceImpl implements ReviewService {
    private final ReviewRepository reviewRepository;
    public ReviewServiceImpl(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @Override
    public Review findReviewById(int id) {
        return reviewRepository.findById(id).orElse(null);
    }

    @Override
    public List<Review> findAllReviews() {
        return reviewRepository.findAll();
    }

    @Override
    public Review saveReview(Review review) {
        return reviewRepository.save(review);
    }

    @Override
    public boolean deleteReviewById(int id) {
            if (reviewRepository.existsById(id)) {
                reviewRepository.deleteById(id);
                return true;
            }
            return false;
    }

    @Override
    public Review updateReview(Review review) {
        if (review == null || review.getId() == null) {
            throw new IllegalArgumentException("Review id cannot be null");
        }
        Review existingReview = reviewRepository.findById(review.getId()).orElseThrow(() -> new EntityNotFoundException("Review not found"));
        updateReviewFields(existingReview, review);
       return reviewRepository.save(existingReview);
    }

    public void updateReviewFields(Review existingReview, Review updatedReview) {
        if (updatedReview.getContent() != null) {
            existingReview.setContent(updatedReview.getContent());
        }
        if (updatedReview.getRating() != null) {
            existingReview.setRating(updatedReview.getRating());
        }
    }
}
