package com.bdms.donor.controller;

import com.bdms.common.response.ApiResponse;
import com.bdms.common.response.PagedResponse;
import com.bdms.donor.dto.CreateDonorRequest;
import com.bdms.donor.dto.DonorProfileResponse;
import com.bdms.donor.dto.DonorSearchResponse;
import com.bdms.donor.dto.UpdateDonorRequest;
import com.bdms.donor.entity.BloodGroup;
import com.bdms.donor.service.DonorService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/donors")
@RequiredArgsConstructor
public class DonorController {
    private final DonorService donorService;

    @PostMapping
    public ResponseEntity<ApiResponse<String>> createDonorProfile(@Valid @RequestBody CreateDonorRequest request){
        donorService.createDonorProfile(request);
        ApiResponse<String> response =ApiResponse.success("Donor profile created successfully","Donor profile created");
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
    @GetMapping("/me")
    public ResponseEntity<ApiResponse<DonorProfileResponse>> getMyDonorProfile(){
        DonorProfileResponse byDonorProfile = donorService.getMyDonorProfile();
        ApiResponse<DonorProfileResponse> response = ApiResponse.success("Donor profile fetched successfully", byDonorProfile);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }
    @PutMapping("/me")
    public ResponseEntity<ApiResponse<DonorProfileResponse>> updateMyDonorProfile(@Valid @RequestBody UpdateDonorRequest request){
        DonorProfileResponse response = donorService.updateMyDonorProfile(request);
        ApiResponse<DonorProfileResponse> donorProfileUpdatedSuccessfully = ApiResponse.success("Donor profile updated successfully", response);
        return new ResponseEntity<>(donorProfileUpdatedSuccessfully,HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<ApiResponse<PagedResponse<DonorSearchResponse>>> searchDonors(
            @RequestParam BloodGroup bloodGroup,
            @RequestParam String city,
            @RequestParam(defaultValue = "0")int page,
            @RequestParam(defaultValue = "10")int size
            ){
        PagedResponse<DonorSearchResponse> donors = donorService.searchDonors(bloodGroup,city,page,size);
        ApiResponse<PagedResponse<DonorSearchResponse>> response = ApiResponse.success("Donors fetched successfully", donors);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }
}
