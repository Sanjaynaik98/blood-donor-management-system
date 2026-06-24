package com.bdms.user.controller;

import com.bdms.common.response.ApiResponse;
import com.bdms.user.dto.UserRegistrationRequest;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/users")
public class UserController {

    @PostMapping("/register")
    public ApiResponse<String> register(@Valid @RequestBody UserRegistrationRequest request){
        return ApiResponse.<String>builder().success(true).message("Validation successful").data("User Registered").build();
    }
}


