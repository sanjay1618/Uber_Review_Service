package com.example.uber.Adapters;

import com.example.uber.DTOs.CreateReviewDTO;
import com.example.uber.Models.Booking;
import com.example.uber.Models.Review;
import com.example.uber.Repositories.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CreateReviewDtoToReviewAdapter {
    BookingRepository bookingRepository;

    @Autowired
    public CreateReviewDtoToReviewAdapter(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }
    public Review convertToReview(CreateReviewDTO createReviewDTO) {
        Optional<Booking> booking = bookingRepository.findById(createReviewDTO.getBookingId());
        Review review = null;
        if (booking.isPresent()) {
             review = Review.builder()
                    .content(createReviewDTO.getContent())
                    .rating(createReviewDTO.getRating())
                    .booking(booking.get())
                    .build();
            return review;
        }
       return null;
    }

}
