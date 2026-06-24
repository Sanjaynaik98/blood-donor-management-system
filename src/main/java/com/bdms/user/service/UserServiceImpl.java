package com.bdms.user.service;

import com.bdms.common.exception.BadRequestException;
import com.bdms.user.dto.UserRegistrationRequest;
import com.bdms.user.entity.User;
import com.bdms.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;
    @Override
    public void register(UserRegistrationRequest request) {
        if(userRepository.existsByEmail(request.getEmail())){
            throw new BadRequestException("Email already registered");
        }
        User user= User.builder()
                .name(request.getName())
                .email(request.getEmail())
                .password(request.getPassword())
                .isActive(true)
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();
        userRepository.save(user);
    }
}
