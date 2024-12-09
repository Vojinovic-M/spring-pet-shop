package com.example.backend.services;

import com.example.backend.entities.UserEntity;
import com.example.backend.mappers.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import com.example.backend.entities.IUserService;
import com.example.backend.models.UserDtoRegister;
import com.example.backend.repositories.UserRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService implements IUserService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    @Override
    public UserDtoRegister create(UserDtoRegister userDtoRegister) {
        var entity = UserMapper.toEntity(userDtoRegister, passwordEncoder);
        var result = userRepository.save(entity);
        return UserMapper.toDto(result);
    }

    public UserEntity authenticate(String email, String password) {
        UserEntity user = userRepository.findByEmail(email);
        if (user != null && passwordEncoder.matches(password, user.getPassword())) {
            return user;
        }
        return null;
    }


}
