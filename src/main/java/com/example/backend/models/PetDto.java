package com.example.backend.models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PetDto {
    private int id;
    private String name;
    private String description;
    private String breed;
    private Integer age;
    private Integer size;
    private String origin;
    private Integer price;
    private String imageUrl;
}
