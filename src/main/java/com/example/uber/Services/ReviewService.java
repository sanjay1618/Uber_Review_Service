package com.example.uber.Services;

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


        Long count = reviewRepository.countAllByRatingBelow(3);
        System.out.println(count);

        Review r = reviewRepository.findReviewByBookingId(1);

            System.out.println(r.getContent());
            System.out.println(r.getRating());

    }
}
