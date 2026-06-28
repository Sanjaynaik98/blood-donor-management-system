package com.bdms.hospital.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class HospitalProfileResponse {

    private Long id;
    private String name;
    private String phone;
    private String address;
    private String city;
    private String state;
    private String licenseNumber;
}
