package com.example.backend.mappers;

import com.example.backend.entities.OrderEntity;
import com.example.backend.models.OrderResponseDto;

public class OrderMapper {

    public static OrderResponseDto toResponseDto(OrderEntity entity) {
        OrderResponseDto dto = new OrderResponseDto();
        dto.setId(entity.getId());
        dto.setPetId(entity.getPet().getId());
        dto.setUserId(entity.getUser().getId());
        dto.setOrderStatus(entity.getOrderStatus());
        dto.setCreatedAt(entity.getCreatedAt());
        dto.setUpdatedAt(entity.getUpdatedAt());
        dto.setRating(entity.getRating());
        return dto;
    }
}
