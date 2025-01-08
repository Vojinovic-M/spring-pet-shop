package com.example.backend.controllers;

import com.example.backend.entities.OrderEntity;
import com.example.backend.enums.OrderStatus;
import com.example.backend.models.OrderDto;
import com.example.backend.services.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    public ResponseEntity<OrderEntity> updateOrderStatus(
            @PathVariable int orderId,
            @RequestParam OrderStatus orderStatus) {
        OrderEntity updatedOrder = orderService.updateOrderStatus(orderId, orderStatus);
        return ResponseEntity.ok(updatedOrder);
    }
}
