package com.example.uber.Repositories;

import com.example.uber.Models.Booking;
import com.example.uber.Models.Driver;
import com.example.uber.Models.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Long> {




}
