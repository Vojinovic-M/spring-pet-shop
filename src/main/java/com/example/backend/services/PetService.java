package com.example.backend.services;

import com.example.backend.entities.PetEntity;
import com.example.backend.mappers.PetMapper;
import com.example.backend.models.PetDistanceDto;
import com.example.backend.models.PetDto;
import com.example.backend.repositories.IPetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static com.example.backend.mappers.PetMapper.toPetDto;


@Service
@RequiredArgsConstructor
public class PetService {
    private final IPetRepository IPetRepository;

    public Page<PetDto> getAllPets(Pageable pageable) {
        return IPetRepository.findAll(pageable).map(PetMapper::toPetDto);
    }

    public PetDto getPetById(Integer id) {
        PetEntity pet = IPetRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("Pet not found with ID: " + id));
        return toPetDto(pet);
    }

    public List<PetDistanceDto> getPetsWithDistance(double userLat, double userLng) {
        List<Object[]> results = IPetRepository.findAllPetsWithDistance(userLat, userLng);

        return results.stream()
                .map(result -> new PetDistanceDto((PetEntity) result[0], (Double) result[1]))
                .sorted(Comparator.comparing(PetDistanceDto::getDistance))
                .collect(Collectors.toList());
    }
}
