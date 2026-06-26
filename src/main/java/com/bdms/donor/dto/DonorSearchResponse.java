package com.bdms.donor.dto;

import com.bdms.donor.entity.BloodGroup;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DonorSearchResponse {
    private Long id;
    private String name;
    private BloodGroup bloodGroup;
    private String city;
    private String state;
    private String phone;
}
