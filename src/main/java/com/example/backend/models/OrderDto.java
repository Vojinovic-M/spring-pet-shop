package com.example.backend.models;

import lombok.Getter;
import lombok.Setter;
// TREBACE OVO DA BUDE ORDER REQUEST DTO U JEDNOM TRENUTKU
// I DA NAPRAVIM ORDER RESPONSE DTO ZA LAZY LOADING JSON
// ZBOG PERFORMANSI,ZA SAD JE OK DA BUDE LOADING EAGER
@Getter
@Setter
public class OrderDto {
    private Integer petId;
    private Integer userId;
}
