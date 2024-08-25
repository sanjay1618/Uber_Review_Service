package com.example.uber.Services;

import com.example.uber.Models.Booking;
import com.example.uber.Models.Driver;
import com.example.uber.Repositories.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jdbc.core.ColumnMapRowMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DriverService implements CommandLineRunner {


    DriverRepository driverRepository;
    @Autowired
    public DriverService(DriverRepository driverRepository) {
        this.driverRepository = driverRepository;
    }

    public void run(String... args) throws Exception {

        Optional<Driver> driver = driverRepository.rawFindDriverById(1L);
        if(driver.isPresent()) {
            System.out.println(driver.get().getName());
            List<Booking> b = driver.get().getBookings();
            for(Booking booking : b) {
                System.out.println(booking.getBookingStatus());
            }
        }

    }


}
