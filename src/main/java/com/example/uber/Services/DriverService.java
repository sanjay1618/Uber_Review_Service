package com.example.uber.Services;

import com.example.uber.DTOs.CustomDriver;
import com.example.uber.Models.Booking;
import com.example.uber.Models.Driver;
import com.example.uber.Repositories.DriverRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jdbc.core.ColumnMapRowMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class DriverService implements CommandLineRunner {


    DriverRepository driverRepository;
    @Autowired
    public DriverService(DriverRepository driverRepository) {
        this.driverRepository = driverRepository;
    }

    public void run(String... args) throws Exception {

//        Optional<CustomDriver> driver = driverRepository.rawFindDriverById(1L);
//        if(driver.isPresent()) {
//            System.out.println(driver.get().getLicenseNumber());
//            List<Booking> b = driver.get().getBookings();
//            for(Booking booking : b) {
//                System.out.println(booking.getBookingStatus());
//            }
//        }
//


       List<Driver> drivers = driverRepository.findAllByIdIn(new ArrayList<>(Arrays.asList(1, 2, 3)));
       for(Driver driver: drivers) {
          List<Booking> bookings = driver.getBookings();
          bookings.forEach(booking -> System.out.println(booking.getBookingStatus()));
       }

    }


}
