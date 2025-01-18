package com.example.backend.repositories;

import com.example.backend.entities.OrderEntity;
import com.example.backend.enums.OrderStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IOrderRepository extends JpaRepository<OrderEntity, Integer> {
    List<OrderEntity> findByOrderStatus(OrderStatus orderStatus);
    List<OrderEntity> findByUserId(int userId);

    @Query("SELECT o FROM OrderEntity o JOIN FETCH o.user u WHERE u.id = :userId")
    List<OrderEntity> findOrdersByUserId(int userId);
}
