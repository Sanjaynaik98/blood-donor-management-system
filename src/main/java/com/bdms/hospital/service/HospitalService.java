package com.bdms.hospital.service;

import com.bdms.hospital.dto.CreateHospitalRequest;
import com.bdms.hospital.dto.HospitalProfileResponse;
import com.bdms.hospital.dto.UpdateHospitalRequest;

public interface HospitalService {

    void createHospitalProfile(CreateHospitalRequest request);
    HospitalProfileResponse getMyHospitalProfile();
    HospitalProfileResponse updateMyHospitalProfile(UpdateHospitalRequest request);

}
