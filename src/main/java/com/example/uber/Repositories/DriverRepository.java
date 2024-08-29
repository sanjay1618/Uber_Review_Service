package com.example.uber.Repositories;

import com.example.uber.DTOs.CustomDriver;
import com.example.uber.Models.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface DriverRepository extends JpaRepository<Driver, Integer> {





}
