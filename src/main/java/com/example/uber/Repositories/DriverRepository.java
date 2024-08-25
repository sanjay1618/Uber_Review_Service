package com.example.uber.Repositories;

import com.example.uber.Models.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface DriverRepository extends JpaRepository<Driver, Integer> {

    @Query(nativeQuery = true,value = "SELECT * FROM driver WHERE id=:id")
    Optional<Driver> rawFindDriverById(Long id);
}
