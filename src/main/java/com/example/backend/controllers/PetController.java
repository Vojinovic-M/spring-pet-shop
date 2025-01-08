package com.example.backend.controllers;

import com.example.backend.models.PetDto;
import com.example.backend.services.PetService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pets")
@RequiredArgsConstructor
public class PetController {
    private final PetService petService;

    @GetMapping("/list")
    public ResponseEntity<Page<PetDto>> getAllPets(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        Page<PetDto> pets = petService.getAllPets((Pageable) PageRequest.of(page, size));
        return ResponseEntity.ok(pets);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PetDto> getPetById(@PathVariable Integer id) {
        PetDto pet = petService.getPetById(id);
        return ResponseEntity.ok(pet);
    }
}
