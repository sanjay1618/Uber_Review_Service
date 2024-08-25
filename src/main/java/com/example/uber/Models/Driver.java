package com.example.uber.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Driver extends BaseModel {
    private String name;

    @Column(nullable = false)
    private String licenseNumber;

    @OneToMany(mappedBy="driver", fetch = FetchType.LAZY)
    private List<Booking> bookings = new ArrayList<>();
}
