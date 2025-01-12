package com.example.backend.models;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class OrderStatusUpdateDto {
    private String status;
}
