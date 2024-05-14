package com.dacs.beshop.services;

import com.dacs.beshop.dto.request.UserRequestDto;
import com.dacs.beshop.dto.response.UserDto;
import com.dacs.beshop.entities.User;

import java.util.List;

public interface UserService {
    User getUserByEmail(String email);
    User getUserByUsername(String username);
    User getUserById(Integer userId);
    List<User> getAllUsers();
    void saveUser(UserRequestDto userRequestDto);
    void updateUser(Integer userId, UserDto userDto);
    void deleteUser(Integer userId);
}
