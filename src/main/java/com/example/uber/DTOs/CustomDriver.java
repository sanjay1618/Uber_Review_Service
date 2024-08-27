package com.example.uber.DTOs;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomDriver {
    private int id;
    private String licenseNumber;

}
