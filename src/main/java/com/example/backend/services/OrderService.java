package com.example.backend.services;
import com.example.backend.entities.OrderEntity;
import com.example.backend.entities.PetEntity;
import com.example.backend.entities.UserEntity;
import com.example.backend.enums.OrderStatus;
import com.example.backend.mappers.OrderMapper;
import com.example.backend.models.OrderResponseDto;
import com.example.backend.repositories.IOrderRepository;
import com.example.backend.repositories.IPetRepository;
import com.example.backend.repositories.IUserRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
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

    public OrderEntity createOrder(String userId, Integer petId) {
        UserEntity user;

        if (userId.matches("\\d+")) {
            user = IUserRepository.findById(Integer.parseInt(userId))
                    .orElseThrow(() -> new IllegalArgumentException("User not found"));
        } else {
            user = IUserRepository.findByGoogleId(userId)
                    .orElseThrow(() -> new IllegalArgumentException("Google user not found"));
        }

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

//    public List<OrderResponseDto> getOrders() {
//        // Fetch the authenticated user's email
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        if (authentication != null && authentication.getPrincipal() instanceof UserDetails userDetails) {
//            String email = userDetails.getUsername();
//            // Retrieve the user entity using their email
//            UserEntity user = IUserRepository.findByEmail(email)
//                    .orElseThrow(() -> new IllegalArgumentException("User not found"));
//
//            // Fetch orders for the authenticated user
//            List<OrderEntity> orders = IOrderRepository.findByUserId(user.getId());
//            return orders.stream()
//                    .map(OrderMapper::toResponseDto)
//                    .collect(Collectors.toList());
//        } else {
//            throw new IllegalArgumentException("Unauthorized user");
//        }
//    }
//
    public List<OrderResponseDto> getOrdersByUserId(int userId) {
        List<OrderEntity> orders = IOrderRepository.findByUserId(userId);
        return orders.stream()
                .map(OrderMapper::toResponseDto)
                .collect(Collectors.toList());
    }
}
