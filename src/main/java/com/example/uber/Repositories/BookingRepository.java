package com.example.uber.Repositories;

import com.example.uber.Models.Booking;
import com.example.uber.Models.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Long> {

    List<Booking> findBookingsByDriverIn(List<Driver> drivers);


}
