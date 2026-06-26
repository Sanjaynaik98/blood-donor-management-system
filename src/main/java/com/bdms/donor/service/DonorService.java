package com.bdms.donor.service;

import com.bdms.donor.dto.CreateDonorRequest;
import com.bdms.donor.dto.DonorProfileResponse;
import com.bdms.donor.dto.DonorSearchResponse;
import com.bdms.donor.dto.UpdateDonorRequest;
import com.bdms.donor.entity.BloodGroup;

import java.util.List;

public interface DonorService {

    void createDonorProfile(CreateDonorRequest request);
    DonorProfileResponse getMyDonorProfile();
    DonorProfileResponse updateMyDonorProfile(UpdateDonorRequest request);
    List<DonorSearchResponse> searchDonors(BloodGroup bloodGroup);
}
