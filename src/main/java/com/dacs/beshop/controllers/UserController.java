package com.dacs.beshop.controllers;

import com.dacs.beshop.dto.request.UserRequestDto;
import com.dacs.beshop.dto.response.ResponseDto;
import com.dacs.beshop.dto.response.UserDto;
import com.dacs.beshop.mapper.UserMapper;
import com.dacs.beshop.services.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<UserDto> getAllUsers() {
        return userService.getAllUsers().stream().map(UserMapper::toUserDto).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public UserDto getUserById(@PathVariable Integer id) {
        return UserMapper.toUserDto(userService.getUserById(id));
    }

    @PostMapping
    public ResponseEntity<ResponseDto> addUser(@Valid @RequestBody UserRequestDto userRequestDto) {
        userService.saveUser(userRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseDto(HttpStatus.CREATED.value(), "User created successfully"));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseDto> updateUser(@PathVariable Integer id, @Valid @RequestBody UserDto userDto) {
        userService.updateUser(id, userDto);
        return ResponseEntity.ok(new ResponseDto(HttpStatus.OK.value(), "User updated successfully"));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseDto> deleteUser(@PathVariable Integer id) {
        userService.deleteUser(id);
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseDto(HttpStatus.OK.value(), "User deleted successfully"));
    }
}
