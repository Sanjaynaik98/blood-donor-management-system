package com.bdms.user.service;

import com.bdms.common.exception.BadRequestException;
import com.bdms.common.exception.ResourceNotFoundException;
import com.bdms.security.jwt.JwtService;
import com.bdms.user.dto.LoginRequest;
import com.bdms.user.dto.UserProfileResponse;
import com.bdms.user.dto.UserRegistrationRequest;
import com.bdms.user.entity.Role;
import com.bdms.user.entity.User;
import com.bdms.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    @Override
    public void register(UserRegistrationRequest request) {
        if(userRepository.existsByEmail(request.getEmail())){
            throw new BadRequestException("Email already registered");
        }
        User user= User.builder()
                .name(request.getName())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .isActive(true)
                .role(Role.DONOR)
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();
        userRepository.save(user);
    }

    @Override
    public String login(LoginRequest request) {
        User user = userRepository.findByEmail(request.getEmail()).orElseThrow(() ->
                new BadRequestException("Invalid email or password"));
        if(!passwordEncoder.matches(request.getPassword(),user.getPassword())){
            throw new BadRequestException("Invalid email or password");
        }
        return jwtService.generateToken(user);
    }

    @Override
    public UserProfileResponse getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        User user = userRepository.findByEmail(email).orElseThrow(() -> new ResourceNotFoundException("User not found"));

        return UserProfileResponse.builder().id(user.getId()).name(user.getName()).email(user.getEmail()).role(user.getRole()).build();
    }
}
