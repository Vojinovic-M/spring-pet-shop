package com.example.backend.entities;

import com.example.backend.models.UserDtoRegister;

public interface IUserService {
    UserDtoRegister create(UserDtoRegister userDtoRegister);
}
