package com.example.backend.controllers;

import com.example.backend.entities.UserEntity;
import com.example.backend.models.UserDtoLogin;
import com.example.backend.models.UserDtoRegister;
import com.example.backend.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RequestMapping("/user")
@RestController
public class UserController {

    private final UserService userService;
    private final AuthenticationManager authenticationManager;

    public UserController(UserService userService, AuthenticationManager authenticationManager) {
        this.userService = userService;
        this.authenticationManager = authenticationManager;
    }

    @GetMapping("/hello")
    String hello() {
        return "Hello User";
    }

    @PostMapping("/register")
    public ResponseEntity<UserDtoRegister> register(@RequestBody UserDtoRegister userDtoRegister, BindingResult bindingResult) {
        return ResponseEntity.ok(userService.create(userDtoRegister));
    }


    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserDtoLogin loginDto) {
        UserEntity user = userService.authenticate(loginDto.getEmail(), loginDto.getPassword());
        if (user == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
        }

        Map<String, Object> response = new HashMap<>();
        response.put("id", user.getId());
        response.put("firstName", user.getFirstName());
        response.put("lastName", user.getLastName());
        response.put("email", user.getEmail());
        response.put("phone", user.getPhone());
        response.put("address", user.getAddress());

        return ResponseEntity.ok(response);
    }

};

