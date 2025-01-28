package com.example.backend.controllers;

import com.example.backend.entities.OrderEntity;
import com.example.backend.entities.UserEntity;
import com.example.backend.enums.OrderStatus;
import com.example.backend.models.OrderDto;
import com.example.backend.models.OrderStatusUpdateDto;
import com.example.backend.models.RatingDto;
import com.example.backend.services.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private final OrderService orderService;
//    private static final Logger logger = LoggerFactory.getLogger(OrderController.class);

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/create")
    public ResponseEntity<OrderEntity> createOrder(@RequestBody OrderDto orderDto, Principal principal) {
        String username = principal.getName();
        OrderEntity createdOrder = orderService.createOrder(orderDto, username);
        return ResponseEntity.ok(createdOrder);
    }

    @PutMapping("/{orderId}/status")
    public ResponseEntity<OrderEntity> updateOrderStatus(
            @PathVariable int orderId,
            @RequestBody OrderStatusUpdateDto orderStatusUpdateDto) {
        try {
            OrderStatus newStatus = OrderStatus.valueOf(orderStatusUpdateDto.getStatus().toUpperCase());
            OrderEntity updatedOrder = orderService.updateOrderStatus(orderId, newStatus);
            return ResponseEntity.ok(updatedOrder);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @PostMapping("/{orderId}/rating")
    public ResponseEntity<?> addRating (
            @PathVariable int orderId,
            @RequestBody RatingDto ratingDto) {
        try {
            boolean success = orderService.addRating(orderId, ratingDto.getRating());
            if (success) {
                return ResponseEntity.ok("Rating saved successfully");
            }
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred");
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed to save rating");
    }

    @GetMapping
    public ResponseEntity<?> getOrders(Authentication authentication) {
        if (authentication == null || !authentication.isAuthenticated()) {
            throw new IllegalArgumentException("No user authenticated");
        }

        UserEntity user = (UserEntity) authentication.getPrincipal();
        return ResponseEntity.ok(user.getOrders());
    }

    @PutMapping("/{orderId}/cancel")
    public ResponseEntity<OrderEntity> cancelOrder(@PathVariable int orderId) {
        try {
            OrderEntity cancelledOrder = orderService.cancelOrder(orderId);
            return ResponseEntity.ok(cancelledOrder);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @GetMapping("/{petId}/ratings")
    public ResponseEntity<?> getRatingsByPetId(@PathVariable int petId) {
        try {
            List<RatingDto> ratings = orderService.getRatingsByPetId(petId);
            if (ratings.isEmpty()) {
                return ResponseEntity.ok("No ratings available for this pet.");
            }
            return ResponseEntity.ok(ratings);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error retrieving ratings: " + e.getMessage());
        }
    }




}
