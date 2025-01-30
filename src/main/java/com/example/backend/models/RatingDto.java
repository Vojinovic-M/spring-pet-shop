package com.example.backend.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RatingDto {
    private String email;
    private int rating;

    // Constructor, Getters, and Setters
    public RatingDto(String email, int rating) {
        this.email = email;
        this.rating = rating;
    }
}
