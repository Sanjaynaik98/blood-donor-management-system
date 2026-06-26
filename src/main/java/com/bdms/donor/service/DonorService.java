package com.bdms.donor.service;

import com.bdms.donor.dto.CreateDonorRequest;
import com.bdms.donor.dto.DonorProfileResponse;

public interface DonorService {

    void createDonorProfile(CreateDonorRequest request);
    DonorProfileResponse getByDonorProfile();
}
