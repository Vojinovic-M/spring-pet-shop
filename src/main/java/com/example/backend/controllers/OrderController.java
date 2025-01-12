package com.example.backend.controllers;

import com.example.backend.entities.OrderEntity;
import com.example.backend.enums.OrderStatus;
import com.example.backend.models.OrderDto;
import com.example.backend.models.OrderResponseDto;
import com.example.backend.services.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/create")
    public OrderEntity createOrder(@RequestBody OrderDto orderDto) {
        return orderService.createOrder(orderDto.getPetId(), orderDto.getUserId());
    }

    @PutMapping("/{orderId}/status")
    public ResponseEntity<OrderEntity> updateOrderStatus(
            @PathVariable int orderId,
            @RequestBody String status) {
        try {
            OrderStatus newStatus = OrderStatus.valueOf(status.toUpperCase());
            OrderEntity updatedOrder = orderService.updateOrderStatus(orderId, newStatus);
            return ResponseEntity.ok(updatedOrder);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @PostMapping("/{orderId}/rating")
    public ResponseEntity<OrderEntity> addRating (
            @PathVariable int orderId,
            @RequestBody int rating) {
        return ResponseEntity.ok(orderService.addRating(orderId, rating));
    }

    @GetMapping
    public List<OrderResponseDto> getAllOrders() {
        return orderService.getAllOrders();
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<OrderResponseDto>> getOrdersByUserId(@PathVariable int userId) {
        return ResponseEntity.ok(orderService.getOrdersByUserId(userId));
    }
}
