package com.example.uber.Repositories;

import java.util.List;
import java.util.Optional;

import com.example.uber.DTOs.CustomDriver;
import com.example.uber.Models.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Integer> {

    @Query(nativeQuery = true,value = "SELECT count(id) from review where rating < :rating")
    Long countAllByRatingBelow(int rating);

    @Query(nativeQuery = true, value = "SELECT * FROM review where rating <= :rating")
    List<Review> findAllByRatingLessThanEqual(int rating);


    @Query("SELECT b.bookingReview from Booking b where b.id = :id")
    Review findReviewByBookingId(Integer id);

}
