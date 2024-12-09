package com.example.backend.mappers;

import com.example.backend.entities.PetEntity;
import com.example.backend.models.PetDto;

public class PetMapper {
    public static PetEntity toPetEntity(PetDto petDto) {
        PetEntity petEntity = new PetEntity();
        petEntity.setId(petDto.getId());
        petEntity.setName(petDto.getName());
        petEntity.setDescription(petDto.getDescription());
        petEntity.setBreed(petDto.getBreed());
        petEntity.setAge(petDto.getAge());
        petEntity.setSize(petDto.getSize());
        petEntity.setOrigin(petDto.getOrigin());
        petEntity.setPrice(petDto.getPrice());
        petEntity.setImageUrl(petDto.getImageUrl());
        return petEntity;
    }

    public static PetDto toPetDto(PetEntity petEntity) {
        return PetDto.builder()
                .id(petEntity.getId())
                .name(petEntity.getName())
                .description(petEntity.getDescription())
                .breed(petEntity.getBreed())
                .age(petEntity.getAge())
                .size(petEntity.getSize())
                .origin(petEntity.getOrigin())
                .price(petEntity.getPrice())
                .imageUrl(petEntity.getImageUrl())
                .build();
    }
}
