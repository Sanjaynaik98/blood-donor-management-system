package com.bdms.donor.dto;

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
public class UpdateDonorRequest {
    @NotBlank
    private String phone;

    @NotBlank
    private String city;

    @NotBlank
    private String state;

    @NotNull
    private  Boolean available;


}
