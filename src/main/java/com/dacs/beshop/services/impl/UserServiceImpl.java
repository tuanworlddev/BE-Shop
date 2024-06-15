package com.dacs.beshop.services.impl;

import com.dacs.beshop.dto.request.UserRequestDto;
import com.dacs.beshop.dto.response.UserDto;
import com.dacs.beshop.entities.Role;
import com.dacs.beshop.entities.User;
import com.dacs.beshop.exceptions.AlreadyExistsException;
import com.dacs.beshop.exceptions.NotFoundException;
import com.dacs.beshop.mapper.UserMapper;
import com.dacs.beshop.repositories.UserRepository;
import com.dacs.beshop.services.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email).orElseThrow(() -> new NotFoundException("User not found"));
    }

    @Override
    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username).orElseThrow(() -> new NotFoundException("User not found"));
    }

    @Override
    public User getUserById(Integer userId) {
        return userRepository.findById(userId).orElseThrow(() -> new NotFoundException("User not found"));
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public void saveUser(UserRequestDto userRequestDto) {
        if (userRepository.existsByEmail(userRequestDto.getEmail())) {
            throw new AlreadyExistsException("User already exists");
        }
        User user = User.builder()
                .firstName(userRequestDto.getFirstName())
                .lastName(userRequestDto.getLastName())
                .email(userRequestDto.getEmail())
                .password(passwordEncoder.encode(userRequestDto.getPassword()))
                .username(UUID.randomUUID().toString())
                .role(Role.USER)
                .avatar("https://avatars.githubusercontent.com/u/162653271?v=4")
                .build();
        userRepository.save(user);
    }

    @Override
    public void updateUser(Integer userId, UserDto userDto) {
        if (!userRepository.existsById(userId)) {
            throw new NotFoundException("User not found");
        }
        User user = UserMapper.toUser(userDto);
        userRepository.save(user);
    }

    @Override
    public void deleteUser(Integer userId) {
        if (!userRepository.existsById(userId)) {
            throw new NotFoundException("User not found");
        }
        userRepository.deleteById(userId);
    }
}
