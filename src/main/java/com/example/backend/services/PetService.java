package com.example.backend.services;

import com.example.backend.entities.PetEntity;
import com.example.backend.mappers.PetMapper;
import com.example.backend.models.PetDto;
import com.example.backend.repositories.PetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import static com.example.backend.mappers.PetMapper.toPetDto;


@Service
@RequiredArgsConstructor
public class PetService {
    private final PetRepository petRepository;

    public Page<PetDto> getAllPets(Pageable pageable) {
        return petRepository.findAll(pageable).map(PetMapper::toPetDto);
    }

    public PetDto getPetById(Integer id) {
        PetEntity pet = petRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("Pet not found with ID: " + id));
        return toPetDto(pet);
    }
}
