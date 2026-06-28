package com.bdms.hospital.service;

import com.bdms.common.exception.BadRequestException;
import com.bdms.common.exception.ResourceNotFoundException;
import com.bdms.hospital.dto.CreateHospitalRequest;
import com.bdms.hospital.dto.HospitalProfileResponse;
import com.bdms.hospital.dto.UpdateHospitalRequest;
import com.bdms.hospital.entity.Hospital;
import com.bdms.hospital.repository.HospitalRepository;
import com.bdms.user.entity.Role;
import com.bdms.user.entity.User;
import com.bdms.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class HospitalServiceImpl implements HospitalService{

    private final HospitalRepository hospitalRepository;
    private final UserRepository userRepository;
    @Override
    public void createHospitalProfile(CreateHospitalRequest request) {
        User user=getCurrentUser();
        if(user.getRole()!= Role.HOSPITAL){
            throw new BadRequestException("Only hospital users can create hospital profiles.");
        }
        if(hospitalRepository.existsByUser(user)){
            throw  new BadRequestException("Hospital profile already exists");
        }
        Hospital hospital=Hospital.builder()
                .user(user)
                .phone(request.getPhone())
                .address(request.getAddress())
                .city(request.getCity())
                .state(request.getState())
                .licenseNumber(request.getLicenseNumber())
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();
        hospitalRepository.save(hospital);
    }

    @Override
    public HospitalProfileResponse getMyHospitalProfile() {
        Hospital hospital = getCurrentHospital();
        return mapToResponse(hospital);
    }

    @Override
    public HospitalProfileResponse updateMyHospitalProfile(UpdateHospitalRequest request) {
        Hospital hospital = getCurrentHospital();
        hospital.setPhone(request.getPhone());
        hospital.setAddress(request.getAddress());
        hospital.setCity(request.getCity());
        hospital.setState(request.getState());
        hospital.setUpdatedAt(LocalDateTime.now());
        hospital= hospitalRepository.save(hospital);
        return mapToResponse(hospital);
    }

    private User getCurrentUser(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        return userRepository.findByEmail(email).orElseThrow(()->new ResourceNotFoundException("User not found"));
    }

    private  Hospital getCurrentHospital(){
        User user =getCurrentUser();
        Hospital hospital = hospitalRepository.findByUser(user).orElseThrow(() -> new ResourceNotFoundException("Hospital not found"));
        return hospital;
    }
    private HospitalProfileResponse mapToResponse(Hospital hospital){
        return HospitalProfileResponse.builder()
                .id(hospital.getId())
                .name(hospital.getUser().getName())
                .phone(hospital.getPhone())
                .address(hospital.getAddress())
                .city(hospital.getCity())
                .state(hospital.getState())
                .licenseNumber(hospital.getLicenseNumber())
                .build();
    }
}
