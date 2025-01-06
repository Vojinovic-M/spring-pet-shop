package com.example.backend.models;


import lombok.Builder;
import lombok.Data;
import lombok.NonNull;
import org.hibernate.validator.constraints.Email;

@Data
@Builder
public class UserDtoRegister {
    private int id;
    private String firstName;
    private String lastName;
    @Email
    private String email;
    private Integer phone;
    private String address;
    private String password;
}
