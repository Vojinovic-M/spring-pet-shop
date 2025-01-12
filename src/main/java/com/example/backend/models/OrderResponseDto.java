package com.example.backend.models;

import com.example.backend.enums.OrderStatus;
import lombok.Data;

import java.time.LocalDateTime;

@Data
    public class OrderResponseDto {
        private Integer id;
        private Integer petId;
        private Integer userId;
        private OrderStatus orderStatus;
        private LocalDateTime createdAt;
        private LocalDateTime updatedAt;
        private Integer rating;
}
