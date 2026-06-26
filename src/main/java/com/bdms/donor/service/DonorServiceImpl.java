package com.bdms.donor.service;

import com.bdms.common.exception.BadRequestException;
import com.bdms.common.exception.ResourceNotFoundException;
import com.bdms.donor.dto.CreateDonorRequest;
import com.bdms.donor.dto.DonorProfileResponse;
import com.bdms.donor.dto.UpdateDonorRequest;
import com.bdms.donor.entity.Donor;
import com.bdms.donor.repository.DonorRepository;
import com.bdms.user.entity.User;
import com.bdms.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class DonorServiceImpl implements DonorService{

    private final DonorRepository donorRepository;
    private final UserRepository userRepository;
    @Override
    public void createDonorProfile(CreateDonorRequest request) {
        User user =getCurrentUser();
        if(donorRepository.existsByUser(user)){
            throw  new BadRequestException("Donor profile already exists");
        }
        Donor donor=Donor.builder().user(user)
                .bloodGroup(request.getBloodGroup())
                .phone(request.getPhone())
                .gender(request.getGender())
                .dateOfBirth(request.getDateOfBirth())
                .city(request.getCity())
                .state(request.getState())
                .available(true)
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();
        donorRepository.save(donor);
    }

    @Override
    public DonorProfileResponse getMyDonorProfile() {
        Donor donor=getCurrentDonor();

        return mapToResponse(donor);
    }

    @Override
    public DonorProfileResponse updateMyDonorProfile(UpdateDonorRequest request) {
        Donor donor=getCurrentDonor();
        donor.setPhone(request.getPhone());
        donor.setCity(request.getCity());
        donor.setState(request.getState());
        donor.setAvailable(request.getAvailable());
        donor.setUpdatedAt(LocalDateTime.now());
        donor=donorRepository.save(donor);
        return mapToResponse(donor);
    }
    
    private Donor getCurrentDonor(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        User user = userRepository.findByEmail(email).orElseThrow(() -> new ResourceNotFoundException("User not found"));

        Donor donor = donorRepository.findByUser(user).orElseThrow(() -> new ResourceNotFoundException("Donor not found"));
        return donor;

    }

    private User getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        String email = authentication.getName();

        return userRepository.findByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
    }
    private DonorProfileResponse mapToResponse(Donor donor){
         return DonorProfileResponse.builder()
                .id(donor.getId())
                .bloodGroup(donor.getBloodGroup())
                .phone(donor.getPhone())
                .gender(donor.getGender())
                .dateOfBirth(donor.getDateOfBirth())
                .city(donor.getCity())
                .state(donor.getState())
                .lastDonationDate(donor.getLastDonationDate())
                .available(donor.getAvailable())
                .build();

    }
}
