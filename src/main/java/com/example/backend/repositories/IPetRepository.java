package com.example.backend.repositories;

import com.example.backend.entities.PetEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IPetRepository extends JpaRepository<PetEntity, Integer> {
    @Query("SELECT p FROM PetEntity p WHERE p.name = :name")
    List<PetEntity> findPet(@Param("name") String name);
}
