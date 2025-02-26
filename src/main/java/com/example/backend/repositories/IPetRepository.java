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

    @Query("SELECT p, (" +
            "6371 * acos( cos( radians(:userLat) ) * cos( radians(p.originLat) ) " +
            "* cos( radians(p.originLng) - radians(:userLng) ) " +
            "+ sin( radians(:userLat) ) * sin( radians(p.originLat) ) ) )" +
            "FROM PetEntity p ")
    List<Object[]> findAllPetsWithDistance(@Param("userLat") double userLat,
                                           @Param("userLng") double userLng);

}
