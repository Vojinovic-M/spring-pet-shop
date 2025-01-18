package com.example.backend.services;
import com.example.backend.entities.OrderEntity;
import com.example.backend.entities.PetEntity;
import com.example.backend.entities.UserEntity;
import com.example.backend.enums.OrderStatus;
import com.example.backend.mappers.OrderMapper;
import com.example.backend.models.OrderDto;
import com.example.backend.models.OrderResponseDto;
import com.example.backend.repositories.IOrderRepository;
import com.example.backend.repositories.IPetRepository;
import com.example.backend.repositories.IUserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    public OrderEntity createOrder(OrderDto orderDto, String username) {

        UserEntity user = IUserRepository.findByUsername(username)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));

        PetEntity pet = IPetRepository.findById(orderDto.getPetId())
                .orElseThrow(() -> new IllegalArgumentException("User not found"));

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
            order.setUpdatedAt(LocalDateTime.now());
            return IOrderRepository.save(order);
        } else {
            throw new IllegalArgumentException("Order not found with ID: " + orderId);
        }
    }

    public OrderEntity addRating(int orderId, int rating) {
        Optional<OrderEntity> optionalOrder = IOrderRepository.findById(orderId);
        if (optionalOrder.isPresent()) {
            OrderEntity order = optionalOrder.get();
            if (order.getOrderStatus() != OrderStatus.COMPLETED) {
                throw new IllegalArgumentException("Only completed orders can be rated");
            }
            order.setRating(rating);
            order.setUpdatedAt(LocalDateTime.now());
            return IOrderRepository.save(order);
        } else {
            throw new IllegalArgumentException("Order not found with ID: " + orderId);
        }
    }

//    public List<OrderResponseDto> getOrdersByUserId(Integer userId) {
//        List<OrderEntity> orders = IOrderRepository.findByUserId(userId);
//        return orders.isEmpty() ? Collections.emptyList() : orders.stream()
//                .map(OrderMapper::toResponseDto)
//                .collect(Collectors.toList());
//    }
//
//    public List<OrderEntity> getOrdersByUserEmail(String email) {
//        UserEntity user = IUserRepository.findByEmail(email)
//                .orElseThrow(() -> new RuntimeException("User not found"));
//        return IOrderRepository.findOrdersByUserId(user.getId());
//    }

    public OrderEntity cancelOrder(int orderId) {
        Optional<OrderEntity> optionalOrder = IOrderRepository.findById(orderId);
        if (optionalOrder.isPresent()) {
            OrderEntity order = optionalOrder.get();
            if (order.getOrderStatus() == OrderStatus.CANCELLED) {
                throw new IllegalArgumentException("Order is already cancelled.");
            }
            if (order.getOrderStatus() == OrderStatus.COMPLETED) {
                throw new IllegalArgumentException("Completed orders cannot be cancelled.");
            }
            order.setOrderStatus(OrderStatus.CANCELLED);
            order.setUpdatedAt(LocalDateTime.now());
            return IOrderRepository.save(order);
        } else {
            throw new IllegalArgumentException("Order not found with ID: " + orderId);
        }
    }

}
