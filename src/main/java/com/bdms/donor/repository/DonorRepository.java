package com.bdms.donor.repository;

import com.bdms.donor.entity.Donor;
import com.bdms.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DonorRepository extends JpaRepository<Donor,Long> {

    Optional<Donor> findByUser(User user);
    boolean existsByUser(User user);
}
