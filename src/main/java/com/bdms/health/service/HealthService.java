package com.bdms.health.service;

import org.springframework.stereotype.Service;

@Service
public class HealthService {

    public String checkHealth(){
        return "UP";
    }
}
