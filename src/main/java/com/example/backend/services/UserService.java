package com.example.backend.services;

import com.example.backend.entities.UserEntity;
import com.example.backend.mappers.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
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

    @Override
    public UserDtoRegister create(UserDtoRegister userDtoRegister) {
        var entity = UserMapper.toEntity(userDtoRegister, passwordEncoder);
        var result = IUserRepository.save(entity);
        return UserMapper.toDto(result);
    }

    public UserEntity authenticate(String email, String password) {
        UserEntity userEntity = IUserRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("Invalid email or password"));
        if (passwordEncoder.matches(password, userEntity.getPassword())) {
            return userEntity;
        } else {
            throw new UsernameNotFoundException("Invalid email or password");
        }
    }


}
