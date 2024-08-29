package com.example.uber.Controllers;

import com.example.uber.Adapters.CreateReviewDtoToReviewAdapter;
import com.example.uber.DTOs.CreateReviewDTO;
import com.example.uber.DTOs.ReviewDTO;
import com.example.uber.Models.Booking;
import com.example.uber.Models.Review;
import com.example.uber.Repositories.BookingRepository;
import com.example.uber.Services.ReviewService;
import com.example.uber.Services.ReviewServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController

@RequestMapping("/api/v1")
public class ReviewController {

    private final BookingRepository bookingRepository;
    ReviewServiceImpl reviewService;
    CreateReviewDtoToReviewAdapter createReviewDtoToReviewAdapter;

    @Autowired
    public ReviewController(ReviewServiceImpl reviewService, BookingRepository bookingRepository, CreateReviewDtoToReviewAdapter createReviewDtoToReviewAdapter) {
        this.reviewService = reviewService;
        this.createReviewDtoToReviewAdapter = createReviewDtoToReviewAdapter;
        this.bookingRepository = bookingRepository;
    }

    @GetMapping("/reviews")
    public ResponseEntity<List<Review>> getAllReviews() {
        List<Review> allReviews = reviewService.findAllReviews();
        if (allReviews.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(allReviews);
        }
        return ResponseEntity.status(HttpStatus.OK).body(allReviews);
    }

    @PutMapping("/review")
    public ResponseEntity<Review> updateReview(@RequestBody Review review) {
        Review updatedReview = reviewService.updateReview(review);
        if (updatedReview == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(updatedReview);
        }
        return ResponseEntity.status(HttpStatus.OK).body(updatedReview);
    }

    @DeleteMapping("/reviews/{id}")
    public ResponseEntity<Boolean> deleteReview(@PathVariable int id) {
        boolean isDeleted = reviewService.deleteReviewById(id);
        if (!isDeleted) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/review")
    public ResponseEntity<ReviewDTO> createReview(@RequestBody CreateReviewDTO reviewDTO) {
       Review review = createReviewDtoToReviewAdapter.convertToReview(reviewDTO);
       Review incomingResponse = reviewService.saveReview(review);
       if (review != null) {
           ReviewDTO response = ReviewDTO.builder()
                   .createdAt(incomingResponse.getCreatedAt())
                   .updatedAt(incomingResponse.getUpdatedAt())
                   .bookingId(incomingResponse.getBooking().getId())
                   .content(incomingResponse.getContent())
                   .rating(incomingResponse.getRating())
                   .id(incomingResponse.getId())
                   .build();
           return ResponseEntity.status(HttpStatus.CREATED).body(response);
       }
       return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}
