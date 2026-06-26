package com.bdms.donor.dto;

import com.bdms.donor.entity.BloodGroup;
import com.bdms.donor.entity.Gender;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateDonorRequest {

    @NotNull
    private BloodGroup bloodGroup;

    @NotBlank
    private String phone;

    @NotNull
    private Gender gender;

    @NotNull
    private LocalDate dateOfBirth;

    @NotBlank
    private String city;

    @NotBlank
    private  String state;

}
