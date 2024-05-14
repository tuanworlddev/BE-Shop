package com.dacs.beshop.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class UserDto {
    private Integer id;
    private String username;
    private String email;
    private String phone;
    private String firstName;
    private String lastName;
    private String avatar;
    private String role;
}
