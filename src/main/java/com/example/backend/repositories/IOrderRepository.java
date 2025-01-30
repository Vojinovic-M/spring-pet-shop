package com.example.backend.repositories;

import com.example.backend.entities.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IOrderRepository extends JpaRepository<OrderEntity, Integer> {
    @Query("SELECT o FROM OrderEntity o WHERE o.pet.id = :petId AND o.rating IS NOT NULL")
    List<OrderEntity> findByPetIdAndRating(@Param("petId") int petId);
    // TEST RATINGS:
//    SELECT u.email, o.rating
//    FROM pets.orders o
//    JOIN pets.users u ON o.user_id = u.id
//    WHERE o.pet_id = 3 AND o.rating IS NOT NULL;
}
