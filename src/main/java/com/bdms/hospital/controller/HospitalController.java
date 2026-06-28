package com.bdms.hospital.controller;

import com.bdms.common.response.ApiResponse;
import com.bdms.donor.dto.DonorProfileResponse;
import com.bdms.hospital.dto.CreateHospitalRequest;
import com.bdms.hospital.dto.HospitalProfileResponse;
import com.bdms.hospital.dto.UpdateHospitalRequest;
import com.bdms.hospital.entity.Hospital;
import com.bdms.hospital.service.HospitalService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("api/v1/hospitals")
@RestController
@RequiredArgsConstructor
public class HospitalController {

    private final HospitalService hospitalService;

    @PostMapping
    public ResponseEntity<ApiResponse<String>> createHospitalProfile(@RequestBody @Valid CreateHospitalRequest request){
        hospitalService.createHospitalProfile(request);
        ApiResponse<String> response = ApiResponse.success("Hospital profile created successfully", "Hospital profile created");
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/me")
    public ResponseEntity<ApiResponse<HospitalProfileResponse>> getMyHospitalProfile(){
        HospitalProfileResponse myHospitalProfile = hospitalService.getMyHospitalProfile();
        ApiResponse<HospitalProfileResponse> response = ApiResponse.success("Hospital profile fetched successfully", myHospitalProfile);
        return  new ResponseEntity<>(response,HttpStatus.OK);
    }

    @PutMapping("/me")
    public ResponseEntity<ApiResponse<HospitalProfileResponse>> updateMyHospitalProfile(@RequestBody @Valid UpdateHospitalRequest request){
        HospitalProfileResponse hospitalProfileResponse = hospitalService.updateMyHospitalProfile(request);
        ApiResponse<HospitalProfileResponse> response = ApiResponse.success("Hospital profile updated successfully", hospitalProfileResponse);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

}
