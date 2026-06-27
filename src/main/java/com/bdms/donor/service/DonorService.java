package com.bdms.donor.service;

import com.bdms.common.response.PagedResponse;
import com.bdms.donor.dto.CreateDonorRequest;
import com.bdms.donor.dto.DonorProfileResponse;
import com.bdms.donor.dto.DonorSearchResponse;
import com.bdms.donor.dto.UpdateDonorRequest;
import com.bdms.donor.entity.BloodGroup;
import org.springframework.data.domain.Page;


import java.util.List;

public interface DonorService {

    void createDonorProfile(CreateDonorRequest request);

    DonorProfileResponse getMyDonorProfile();

    DonorProfileResponse updateMyDonorProfile(UpdateDonorRequest request);

    PagedResponse<DonorSearchResponse> searchDonors(BloodGroup bloodGroup, String city, int page, int size);
}
