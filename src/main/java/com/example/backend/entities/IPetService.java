package com.example.backend.entities;

import com.example.backend.models.PetDto;

public interface IPetService {
    PetDto findPet(PetDto petDto);
}
