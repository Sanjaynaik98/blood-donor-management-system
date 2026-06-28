package com.bdms.hospital.repository;

import com.bdms.hospital.entity.Hospital;
import com.bdms.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface HospitalRepository extends JpaRepository<Hospital,Long> {


    Optional<Hospital> findByUser(User user);
    boolean existsByUser(User user);
}
