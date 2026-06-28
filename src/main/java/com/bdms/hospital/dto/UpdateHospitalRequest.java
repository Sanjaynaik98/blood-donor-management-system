package com.bdms.hospital.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UpdateHospitalRequest {

    @NotBlank
    private String phone;
    @NotBlank
    private String address;
    @NotBlank
    private String city;
    @NotBlank
    private String state;
}
