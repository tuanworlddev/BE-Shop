package com.dacs.beshop.services;

import com.dacs.beshop.dto.request.AuthRequestDto;
import com.dacs.beshop.dto.request.RefreshTokenRequestDto;
import com.dacs.beshop.dto.response.AuthDto;
import com.dacs.beshop.entities.User;

public interface AuthService {
    AuthDto login(AuthRequestDto authRequestDto);
    AuthDto refreshToken(RefreshTokenRequestDto refreshTokenRequestDto);
    User getUserByToken(String token);
}
