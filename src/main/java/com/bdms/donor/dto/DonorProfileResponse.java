package com.bdms.donor.dto;

import com.bdms.donor.entity.BloodGroup;
import com.bdms.donor.entity.Gender;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DonorProfileResponse {

    private Long id;

    private BloodGroup bloodGroup;

    private String phone;

    private Gender gender;

    private LocalDate dateOfBirth;

    private String city;

    private String state;

    private LocalDate lastDonationDate;

    private Boolean available;
}
