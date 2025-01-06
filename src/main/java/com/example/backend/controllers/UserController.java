package com.example.backend.controllers;

import com.example.backend.entities.UserEntity;
import com.example.backend.models.UserDtoLogin;
import com.example.backend.models.UserDtoRegister;
import com.example.backend.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RequestMapping("user")
@RestController
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
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
    public ResponseEntity<?> login(@RequestBody UserDtoLogin loginRequest) {
        UserEntity user = userService.authenticate(loginRequest.getEmail(), loginRequest.getPassword());
        if (user != null) {
            // Construct a response map
            Map<String, Object> response = new HashMap<>();
            response.put("message", "Logged in successfully");
            response.put("user", new HashMap<>() {{
                put("id", user.getId());
                put("firstName", user.getFirstName());
                put("lastName", user.getLastName());
                put("email", user.getEmail());
            }});

            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
        }
    }




}
