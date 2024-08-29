package com.example.uber.DTOs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CreateReviewDTO {
    private String content;
    private Long rating;
    private Long bookingId;

}
