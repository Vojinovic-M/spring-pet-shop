package com.example.backend.models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDtoLogin {
    private String email;
    private String password;
}
