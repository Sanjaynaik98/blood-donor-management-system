package com.bdms.user.controller;

import com.bdms.common.response.ApiResponse;
import com.bdms.user.dto.LoginRequest;
import com.bdms.user.dto.UserProfileResponse;
import com.bdms.user.dto.UserRegistrationRequest;
import com.bdms.user.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    @PostMapping("/register")
    public ApiResponse<String> register(@Valid @RequestBody UserRegistrationRequest request){
        userService.register(request);
        return ApiResponse.<String>builder().success(true).message("User registered successfully").data("User Registered").build();
    }
    @PostMapping("/login")
    public ApiResponse<String> login(@Valid @RequestBody LoginRequest request){
        String token = userService.login(request);
        return  ApiResponse.<String>builder().success(true).message("Login successful").data(token).build();
    }
    @GetMapping("/me")
    public ApiResponse<UserProfileResponse> getCurrentUser() {
        UserProfileResponse currentUser = userService.getCurrentUser();

        return ApiResponse.<UserProfileResponse>builder().success(true).message("User profile fetched successfully").data(currentUser).build();
    }
}


