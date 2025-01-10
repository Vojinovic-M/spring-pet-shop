package com.example.backend.services;

import com.example.backend.entities.UserEntity;
import com.example.backend.mappers.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import com.example.backend.entities.IUserService;
import com.example.backend.models.UserDtoRegister;
import com.example.backend.repositories.IUserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService implements IUserService {
    private final IUserRepository IUserRepository;
    private final BCryptPasswordEncoder passwordEncoder;
    private final IUserRepository userRepository;

    @Override
    public UserDtoRegister create(UserDtoRegister userDtoRegister) {
        var entity = UserMapper.toEntity(userDtoRegister, passwordEncoder);
        var result = IUserRepository.save(entity);
        return UserMapper.toDto(result);
    }

    public UserEntity authenticate(String email, String password) {
        return userRepository.findByEmail(email)
        .filter(user -> passwordEncoder.matches(password, user.getPassword()))
        .orElse(null);
    }
}
