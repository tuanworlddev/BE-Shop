package com.dacs.beshop.mapper;

import com.dacs.beshop.dto.request.UserRequestDto;
import com.dacs.beshop.dto.response.UserDto;
import com.dacs.beshop.entities.Role;
import com.dacs.beshop.entities.User;

public class UserMapper {
    public static UserDto toUserDto(User user) {
        return UserDto.builder()
                .id(user.getId())
                .username(user.getUsername())
                .email(user.getEmail())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .avatar(user.getAvatar())
                .role(user.getRole().name())
                .build();
    }

    public static User toUser(UserDto userDto) {
        return User.builder()
                .id(userDto.getId())
                .username(userDto.getUsername())
                .email(userDto.getEmail())
                .firstName(userDto.getFirstName())
                .lastName(userDto.getLastName())
                .avatar(userDto.getAvatar())
                .role(Role.valueOf(userDto.getRole()))
                .build();
    }
}
