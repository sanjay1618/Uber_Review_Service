package com.example.uber.Services;

import com.example.uber.Models.Booking;
import com.example.uber.Models.BookingStatus;
import com.example.uber.Models.Review;
import com.example.uber.Repositories.BookingRepository;
import com.example.uber.Repositories.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

@Service
public class ReviewService implements CommandLineRunner {
    @Autowired
    ReviewRepository reviewRepository;

    @Autowired
    BookingRepository bookingRepository;


    @Override

    public void run(String... args) throws Exception {
//        System.out.println("Hello World");
//        Review r = Review.builder().content("Amazing ride").build();
//
//
//        Booking b = Booking.builder().bookingReview(r).bookingStatus(BookingStatus.COMPLETED).build();
//        bookingRepository.save(b);
    }

}
