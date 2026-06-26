package com.bdms.config;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public final class SecurityConstants {

    public static final String[] PUBLIC_URLS={
            "/api/v1/health",
            "/api/v1/users/register",
            "/api/v1/users/login",
            "/api/v1/donors/search"
    };
}
