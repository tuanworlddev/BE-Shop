package com.dacs.beshop.controllers;

import com.dacs.beshop.dto.request.AuthRequestDto;
import com.dacs.beshop.dto.request.RefreshTokenRequestDto;
import com.dacs.beshop.dto.response.AuthDto;
import com.dacs.beshop.dto.response.ResponseDto;
import com.dacs.beshop.dto.response.UserDto;
import com.dacs.beshop.mapper.UserMapper;
import com.dacs.beshop.services.AuthService;
import com.dacs.beshop.services.JwtService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private final AuthService authService;
    private final JwtService jwtService;

    public AuthController(AuthService authService, JwtService jwtService) {
        this.authService = authService;
        this.jwtService = jwtService;
    }

    @GetMapping("/user")
    public ResponseEntity<UserDto> getUser(@RequestHeader("Authorization") String token) {
        if (token.startsWith("Bearer ")) {
            token = token.substring(7);
        }
        return ResponseEntity.ok(UserMapper.toUserDto(authService.getUserByToken(token)));
    }

    @GetMapping("/logout")
    public ResponseEntity<ResponseDto> logout(@RequestHeader("Authorization") String token) {
        jwtService.invalidateToken(token);
        return ResponseEntity.ok(new ResponseDto(HttpStatus.OK.value(), "Logged out successfully"));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthDto> login(@Valid @RequestBody AuthRequestDto authRequestDto) {
        return ResponseEntity.ok(authService.login(authRequestDto));
    }

    @PostMapping("/refresh-token")
    public ResponseEntity<AuthDto> refreshToken(@Valid @RequestBody RefreshTokenRequestDto refreshTokenRequestDto) {
        return ResponseEntity.ok(authService.refreshToken(refreshTokenRequestDto));
    }
}
