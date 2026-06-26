package com.bdms.donor.service;

import com.bdms.common.exception.BadRequestException;
import com.bdms.common.exception.ResourceNotFoundException;
import com.bdms.donor.dto.CreateDonorRequest;
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
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();

        User user = userRepository.findByEmail(email).orElseThrow(() -> new ResourceNotFoundException("User not found"));
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
}
