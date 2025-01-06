package com.example.backend.services;
import com.example.backend.entities.OrderEntity;
import com.example.backend.entities.PetEntity;
import com.example.backend.entities.UserEntity;
import com.example.backend.enums.OrderStatus;
import com.example.backend.repositories.IOrderRepository;
import com.example.backend.repositories.IPetRepository;
import com.example.backend.repositories.IUserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class OrderService {

    private final IOrderRepository IOrderRepository;
    private final IUserRepository IUserRepository;
    private final IPetRepository IPetRepository;

    public OrderService(IOrderRepository IOrderRepository, IUserRepository IUserRepository, IPetRepository IPetRepository) {
        this.IOrderRepository = IOrderRepository;
        this.IUserRepository = IUserRepository;
        this.IPetRepository = IPetRepository;
    }

    public OrderEntity createOrder(int userId, int petId) {
        UserEntity user = IUserRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));

        PetEntity pet = IPetRepository.findById(petId)
                .orElseThrow(() -> new IllegalArgumentException("Pet not found"));

        OrderEntity order = new OrderEntity();
        order.setUser(user);
        order.setPet(pet);
        order.setCreatedAt(LocalDateTime.now());
        order.setUpdatedAt(LocalDateTime.now());

        return IOrderRepository.save(order);
    }

    public OrderEntity updateOrderStatus(int orderId, OrderStatus status) {
        Optional<OrderEntity> optionalOrder = IOrderRepository.findById(orderId);
        if (optionalOrder.isPresent()) {
            OrderEntity order = optionalOrder.get();
            order.setOrderStatus(status);
            order.setUpdatedAt(java.time.LocalDateTime.now());
            return IOrderRepository.save(order);
        } else {
            throw new IllegalArgumentException("Order not found with ID: " + orderId);
        }
    }
}
