package com.bdms.user.service;

import com.bdms.user.dto.LoginRequest;
import com.bdms.user.dto.UserProfileResponse;
import com.bdms.user.dto.UserRegistrationRequest;

public interface UserService {

    void register(UserRegistrationRequest request);
    String login(LoginRequest request);
    UserProfileResponse getCurrentUser();
}
