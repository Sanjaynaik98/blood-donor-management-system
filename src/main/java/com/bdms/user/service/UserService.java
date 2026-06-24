package com.bdms.user.service;

import com.bdms.user.dto.UserRegistrationRequest;

public interface UserService {

    void register(UserRegistrationRequest request);
}
