package com.example.backend.mappers;

import com.example.backend.entities.UserEntity;
import com.example.backend.models.UserDtoRegister;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


public class UserMapper {
    public static UserEntity toEntity(UserDtoRegister userDto, BCryptPasswordEncoder passwordEncoder) {
        UserEntity user = new UserEntity();
        user.setId(userDto.getId());
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setEmail(userDto.getEmail());
        user.setPhone(userDto.getPhone());
        user.setAddress(userDto.getAddress());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        return user;
    }

    public static UserDtoRegister toDto(UserEntity userEntity) {
        return UserDtoRegister.builder()
                .id(userEntity.getId())
                .firstName(userEntity.getFirstName())
                .lastName(userEntity.getLastName())
                .email(userEntity.getEmail())
                .phone(userEntity.getPhone())
                .address(userEntity.getAddress())
                .password(userEntity.getPassword())
                .build();
    }
}

