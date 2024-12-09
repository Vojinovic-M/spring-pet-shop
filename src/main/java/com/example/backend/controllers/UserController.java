package com.example.backend.controllers;

import com.example.backend.entities.UserEntity;
import com.example.backend.models.UserDtoLogin;
import com.example.backend.models.UserDtoRegister;
import com.example.backend.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RequestMapping("user")
@RestController
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
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
    public ResponseEntity<String> login(@RequestBody UserDtoLogin loginRequest) {
        UserEntity user = userService.authenticate(loginRequest.getEmail(), loginRequest.getPassword());
        if (user != null) {
            // Generate and return a JWT token or session token (for now, return "logged in").
            return ResponseEntity.ok("Logged in successfully");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
        }
    }


}
