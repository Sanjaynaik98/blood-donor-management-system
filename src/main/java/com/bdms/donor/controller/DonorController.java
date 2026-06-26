package com.bdms.donor.controller;

import com.bdms.common.response.ApiResponse;
import com.bdms.donor.dto.CreateDonorRequest;
import com.bdms.donor.dto.DonorProfileResponse;
import com.bdms.donor.dto.DonorSearchResponse;
import com.bdms.donor.dto.UpdateDonorRequest;
import com.bdms.donor.entity.BloodGroup;
import com.bdms.donor.service.DonorService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    @GetMapping("/me")
    public ApiResponse<DonorProfileResponse> getMyDonorProfile(){
        DonorProfileResponse byDonorProfile = donorService.getMyDonorProfile();
        return ApiResponse.<DonorProfileResponse>builder()
                .success(true)
                .message("Donor profile fetched successfully")
                .data(byDonorProfile)
                .build();
    }
    @PutMapping("/me")
    public ApiResponse<DonorProfileResponse> updateMyDonorProfile(@Valid @RequestBody UpdateDonorRequest request){

        DonorProfileResponse response = donorService.updateMyDonorProfile(request);
        return ApiResponse.<DonorProfileResponse>builder()
                .success(true)
                .message("Donor profile updated successfully")
                .data(response)
                .build();
    }

    @GetMapping("/search")
    public ApiResponse<List<DonorSearchResponse>> searchDonors(
            @RequestParam BloodGroup bloodGroup
            ){

        List<DonorSearchResponse> donors = donorService.searchDonors(bloodGroup);

        return ApiResponse.<List<DonorSearchResponse>>builder()
                .success(true)
                .message("Donors fetched successfully")
                .data(donors)
                .build();

    }
}
