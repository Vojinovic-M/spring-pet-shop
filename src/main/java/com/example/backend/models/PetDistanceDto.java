package com.example.backend.models;

import com.example.backend.entities.PetEntity;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PetDistanceDto {
    private PetEntity pet;
    private double distance;
}
