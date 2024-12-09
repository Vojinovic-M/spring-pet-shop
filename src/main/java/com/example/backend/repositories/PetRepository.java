package com.example.backend.repositories;

import com.example.backend.entities.PetEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PetRepository extends JpaRepository<PetEntity, Integer> {
    @Query("SELECT p FROM PetEntity p WHERE p.name = :name")
    List<PetEntity> findPet(@Param("name") String name);
}
