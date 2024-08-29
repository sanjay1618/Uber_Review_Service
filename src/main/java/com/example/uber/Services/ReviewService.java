package com.example.uber.Services;

import com.example.uber.Models.Review;

import java.util.List;

public interface ReviewService {
    public Review findReviewById(int id);

    public List<Review> findAllReviews();

    public boolean deleteReviewById(int id);

    public Review saveReview(Review review);

    public Review updateReview(Review review);
}
