package com.dacs.beshop.services.impl;

import com.dacs.beshop.entities.CustomUserDetails;
import com.dacs.beshop.entities.User;
import com.dacs.beshop.exceptions.NotFoundException;
import com.dacs.beshop.repositories.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private final UserRepository userRepository;

    public UserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(username).orElseThrow(() -> new NotFoundException("User not found"));
        return new CustomUserDetails(user);
    }
}
