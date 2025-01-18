package com.example.backend.services;

import com.example.backend.entities.UserEntity;
import com.example.backend.mappers.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import com.example.backend.entities.IUserService;
import com.example.backend.models.UserDtoRegister;
import com.example.backend.repositories.IUserRepository;
import org.springframework.stereotype.Service;

import java.util.Map;
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

    public UserEntity registerOrUpdateGoogleUser(Map<String, Object> googleUserData) {
        String googleId = (String) googleUserData.get("googleId");
        String email = (String) googleUserData.get("email");
        String firstName = (String) googleUserData.get("firstName");
        String lastName = (String) googleUserData.get("lastName");

        // Use findByGoogleId to check if the user exists
        return IUserRepository.findByGoogleId(googleId)
                .orElseGet(() -> {
                    // Create a new user if not found
                    UserEntity newUser = new UserEntity();
                    newUser.setGoogleId(googleId);
                    newUser.setEmail(email);
                    newUser.setFirstName(firstName);
                    newUser.setLastName(lastName);
                    newUser.setPassword(""); // Google users don’t need a password
                    return IUserRepository.save(newUser);
                });
    }

    public UserEntity authenticate(String email, String password) {
        Optional<UserEntity> userOptional = IUserRepository.findByEmail(email);
        if (userOptional.isEmpty()) {
            System.out.println("User not found with email " + email);
            return null;
        }
        UserEntity user = userOptional.get();
        if (!passwordEncoder.matches(password, user.getPassword())) {
            System.out.println("Wrong password for user " + email);
            return null;
        }
        System.out.println("Authentication successful for user: " + email);
        return user;
    }
}
