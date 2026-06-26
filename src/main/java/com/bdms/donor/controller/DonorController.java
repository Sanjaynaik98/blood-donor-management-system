package com.bdms.donor.controller;

import com.bdms.common.response.ApiResponse;
import com.bdms.donor.dto.CreateDonorRequest;
import com.bdms.donor.service.DonorService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/donors")
@RequiredArgsConstructor
public class DonorController {
    private final DonorService donorService;

    @PostMapping
    public ApiResponse<String> createDonorProfile(@Valid @RequestBody CreateDonorRequest request){
        donorService.createDonorProfile(request);
        return ApiResponse.<String>builder()
                .success(true)
                .message("Donor profile created successfully")
                .data("Donor profile created")
                .build();
    }
}
