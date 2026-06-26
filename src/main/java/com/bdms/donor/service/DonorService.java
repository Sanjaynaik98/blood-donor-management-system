package com.bdms.donor.service;

import com.bdms.donor.dto.CreateDonorRequest;
import com.bdms.donor.dto.DonorProfileResponse;
import com.bdms.donor.dto.UpdateDonorRequest;

public interface DonorService {

    void createDonorProfile(CreateDonorRequest request);
    DonorProfileResponse getMyDonorProfile();
    DonorProfileResponse updateMyDonorProfile(UpdateDonorRequest request);
}
