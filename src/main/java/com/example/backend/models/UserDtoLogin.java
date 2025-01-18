package com.example.backend.models;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
@Builder
public class UserDtoLogin {
    private String email;
    private String password;
}
