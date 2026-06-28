package com.bdms.donor.specification;

import com.bdms.donor.entity.BloodGroup;
import com.bdms.donor.entity.Donor;
import com.bdms.donor.entity.Gender;
import org.springframework.data.jpa.domain.Specification;

public class DonorSpecification {

    public static Specification<Donor> hasBloodGroup(BloodGroup bloodGroup) {

        return (root, query, criteriaBilider) -> criteriaBilider.equal(root.get("bloodGroup"), bloodGroup);
    }

    public static Specification<Donor> hasCity(String city) {
        return ((root, query, criteriaBuilder) ->

                criteriaBuilder.equal(root.get("city"), city)

        );
    }

    public static Specification<Donor> hasState(String state){
        return ((root, query, criteriaBuilder) ->
                criteriaBuilder.equal(root.get("state"),state)
                );
    }

    public static Specification<Donor> hasGender(Gender gender){
        return((root, query, criteriaBuilder) ->
                criteriaBuilder.equal(root.get("gender"),gender)
        );
    }

    public  static Specification<Donor> hasAvailable(Boolean available){
        return ((root, query, criteriaBuilder) ->
                criteriaBuilder.equal(root.get("available"),available));
    }
}

