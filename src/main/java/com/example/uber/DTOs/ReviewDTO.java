package com.example.uber.DTOs;

import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class ReviewDTO {
    private String content;
    private Long rating;
    public Integer id;
    public Integer bookingId;
    public Date createdAt;
    public Date updatedAt;
}
