package com.example.uber.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Passenger extends BaseModel{
    private String name;

    @OneToMany(mappedBy="passenger")
    private List<Booking> bookingList = new ArrayList<>();
}
