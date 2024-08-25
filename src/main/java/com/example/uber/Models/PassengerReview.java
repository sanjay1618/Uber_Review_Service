package com.example.uber.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class PassengerReview extends Review{
    @Column(nullable = false)
    private Long passengerRating;

    @Column
    private String passengerReview;
}
