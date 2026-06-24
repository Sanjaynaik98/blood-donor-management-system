package com.bdms.health.controller;

import com.bdms.common.response.ApiResponse;
import com.bdms.health.service.HealthService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/health")
@AllArgsConstructor
public class HealthController {

    private final HealthService healthService;

    @GetMapping
    public ApiResponse<String> checkHealth() {

        return ApiResponse.<String>builder()
                        .success(true)
                .message("Application is running")
                .data(healthService.checkHealth())
                .build();
    }
}
