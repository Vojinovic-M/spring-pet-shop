package com.example.backend.controllers;

import com.example.backend.entities.UserEntity;
import com.example.backend.models.UserDtoLogin;
import com.example.backend.models.UserDtoRegister;
import com.example.backend.services.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
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


//    @PostMapping("/login")
//    public ResponseEntity<?> login(@RequestBody UserDtoLogin loginDto, HttpSession session) {
//        UserEntity user = userService.authenticate(loginDto.getEmail(), loginDto.getPassword());
//        if (user == null) {
//            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
//        } else {
//            session.setAttribute("userId", user.getId());
//            return ResponseEntity.ok().body("Login successful");
//            Map<String, Object> response = new HashMap<>();
//            response.put("id", user.getId());
//            response.put("firstName", user.getFirstName());
//            response.put("lastName", user.getLastName());
//            response.put("email", user.getEmail());
//            response.put("phone", user.getPhone());
//            response.put("address", user.getAddress());
//            return ResponseEntity.ok(response);
//        }
//    }
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserDtoLogin loginDto) {
        try {
            UsernamePasswordAuthenticationToken authToken =
                    new UsernamePasswordAuthenticationToken(loginDto.getEmail(), loginDto.getPassword());

            Authentication authentication = authenticationManager.authenticate(authToken);
            SecurityContextHolder.getContext().setAuthentication(authentication);

            // Retrieve authenticated user details
            UserEntity user = (UserEntity) authentication.getPrincipal();
            Map<String, Object> response = new HashMap<>();
            response.put("id", user.getId());
            response.put("firstName", user.getFirstName());
            response.put("lastName", user.getLastName());
            response.put("email", user.getEmail());
            response.put("phone", user.getPhone());
            response.put("address", user.getAddress());
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
        }
    }


    @PostMapping("/google-login")
    public ResponseEntity<?> googleLogin(@RequestBody Map<String, String> googleProfile) {
        Map<String, Object> googleUserData = new HashMap<>();
        googleUserData.put("googleId", googleProfile.get("sub")); // "sub" is the Google ID
        googleUserData.put("email", googleProfile.get("email"));
        googleUserData.put("firstName", googleProfile.get("given_name"));
        googleUserData.put("lastName", googleProfile.get("family_name"));

        try {
            UserEntity user = userService.registerOrUpdateGoogleUser(googleUserData);
            UsernamePasswordAuthenticationToken authToken =
                    new UsernamePasswordAuthenticationToken(user, null, List.of());
            SecurityContextHolder.getContext().setAuthentication(authToken);
            return ResponseEntity.ok(user);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
};

