package com.dacs.beshop.services;

import org.springframework.security.core.userdetails.UserDetails;

public interface JwtService {
    String extractEmail(String token);
    String generateToken(UserDetails userDetails);
    String generateTokenRefresh(UserDetails userDetails);
    Boolean isTokenValid(String token);
}
