package com.bdms.donor.repository;

import com.bdms.donor.entity.BloodGroup;
import com.bdms.donor.entity.Donor;
import com.bdms.user.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface DonorRepository extends JpaRepository<Donor,Long>, JpaSpecificationExecutor<Donor> {

    Optional<Donor> findByUser(User user);
    boolean existsByUser(User user);

    Page<Donor> findByBloodGroupAndAvailableTrue(BloodGroup bloodGroup, Pageable pageable);
    Page<Donor> findByBloodGroupAndCityAndAvailableTrue(BloodGroup bloodGroup,String city,Pageable pageable);

    @Query("""
            SELECT d FROM Donor d
            WHERE d.bloodGroup=:bloodGroup
            AND d.city=:city
            AND d.available=true
            """)
    Page<Donor> searchDonors(
            @Param("bloodGroup") BloodGroup bloodGroup,
            @Param("city")String city,
            Pageable pageable
    );
}
