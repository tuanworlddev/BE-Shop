package com.dacs.beshop.services.impl;

import com.dacs.beshop.dto.request.AuthRequestDto;
import com.dacs.beshop.dto.request.RefreshTokenRequestDto;
import com.dacs.beshop.dto.response.AuthDto;
import com.dacs.beshop.entities.CustomUserDetails;
import com.dacs.beshop.entities.User;
import com.dacs.beshop.exceptions.InvalidException;
import com.dacs.beshop.exceptions.NotFoundException;
import com.dacs.beshop.repositories.UserRepository;
import com.dacs.beshop.services.AuthService;
import com.dacs.beshop.services.JwtService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {
    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;

    public AuthServiceImpl(UserRepository userRepository, JwtService jwtService, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.jwtService = jwtService;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public AuthDto login(AuthRequestDto authRequestDto) {
        User user = userRepository.findByEmail(authRequestDto.getEmail()).orElseThrow(() -> new NotFoundException("User not found"));
        if (passwordEncoder.matches(authRequestDto.getPassword(), user.getPassword())) {
            UserDetails userDetails = new CustomUserDetails(user);
            return new AuthDto(jwtService.generateToken(userDetails), jwtService.generateTokenRefresh(userDetails));
        }
        throw new InvalidException("User invalid");
    }

    @Override
    public AuthDto refreshToken(RefreshTokenRequestDto refreshTokenRequestDto) {
        final String email = jwtService.extractEmail(refreshTokenRequestDto.getRefreshToken());
        UserDetails userDetails = new CustomUserDetails(userRepository.findByEmail(email).orElseThrow(() -> new NotFoundException("User not found")));
        if (jwtService.isTokenValid(refreshTokenRequestDto.getRefreshToken())) {
            return new AuthDto(jwtService.generateToken(userDetails), refreshTokenRequestDto.getRefreshToken());
        }
        throw new InvalidException("Refresh token invalid");
    }
}
