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

    @Override
    public UserDtoRegister create(UserDtoRegister userDtoRegister) {
        var entity = UserMapper.toEntity(userDtoRegister, passwordEncoder);
        var result = IUserRepository.save(entity);
        return UserMapper.toDto(result);
    }

    public Optional<UserEntity> createGoogleUser(String googleId, String email, String firstName, String lastName) {
        Optional<UserEntity> existingUser = IUserRepository.findByGoogleId(googleId);
        if (existingUser.isPresent()) {
            return existingUser; // User already exists
        }

        UserEntity newUser = new UserEntity();
        newUser.setGoogleId(googleId);
        newUser.setEmail(email);
        newUser.setFirstName(firstName);
        newUser.setLastName(lastName);

        return Optional.of(IUserRepository.save(newUser));
    }


    public UserEntity authenticate(String email, String password) {
        return IUserRepository.findByEmail(email)
        .filter(user -> passwordEncoder.matches(password, user.getPassword()))
        .orElse(null);
    }

}
