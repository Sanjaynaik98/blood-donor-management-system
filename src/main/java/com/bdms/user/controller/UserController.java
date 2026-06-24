package com.bdms.user.controller;

import com.bdms.common.response.ApiResponse;
import com.bdms.user.dto.UserRegistrationRequest;
import com.bdms.user.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    @PostMapping("/register")
    public ApiResponse<String> register(@Valid @RequestBody UserRegistrationRequest request){
        userService.register(request);
        return ApiResponse.<String>builder().success(true).message("User registered successfully").data("User Registered").build();
    }
}


