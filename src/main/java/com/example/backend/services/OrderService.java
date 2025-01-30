package com.example.backend.services;
import com.example.backend.entities.OrderEntity;
import com.example.backend.entities.PetEntity;
import com.example.backend.entities.UserEntity;
import com.example.backend.enums.OrderStatus;
import com.example.backend.models.OrderDto;
import com.example.backend.models.RatingDto;
import com.example.backend.repositories.IOrderRepository;
import com.example.backend.repositories.IPetRepository;
import com.example.backend.repositories.IUserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
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

    public boolean addRating(int orderId, int rating) {
        if (rating < 1 || rating > 5) {
            throw new IllegalArgumentException("Rating must be between 1 and 5");
        }

        Optional<OrderEntity> optionalOrder = IOrderRepository.findById(orderId);
        if (optionalOrder.isPresent()) {
            OrderEntity order = optionalOrder.get();
            if (order.getOrderStatus() != OrderStatus.COMPLETED) {
                throw new IllegalArgumentException("Only completed orders can be rated");
            }
            order.setRating(rating);
            order.setUpdatedAt(LocalDateTime.now());
            IOrderRepository.save(order);
            return true;
        } else {
            throw new IllegalArgumentException("Order not found with ID: " + orderId);
        }
    }

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

    public List<RatingDto> getRatingsByPetId(int petId) {
        List<OrderEntity> orders = IOrderRepository.findByPetIdAndRating(petId);

        return orders.stream()
                .map(order -> new RatingDto(order.getUser().getEmail(), order.getRating()))
                .toList();
    }



}
