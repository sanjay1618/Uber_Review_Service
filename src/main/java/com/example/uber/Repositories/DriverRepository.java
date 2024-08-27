package com.example.uber.Repositories;

import com.example.uber.DTOs.CustomDriver;
import com.example.uber.Models.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface DriverRepository extends JpaRepository<Driver, Integer> {

    @Query("SELECT new com.example.uber.DTOs.CustomDriver(d.id, d.licenseNumber) FROM Driver d WHERE d.id=:id")
    Optional<CustomDriver> rawFindDriverById(Long id); //Returning custom objects.


    List<Driver> findAllByIdIn(List<Integer> ids);

}
