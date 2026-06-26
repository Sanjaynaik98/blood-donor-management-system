package com.bdms.donor.entity;

import com.bdms.user.entity.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name="donors")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Donor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name="user_id",nullable = false,unique = true)
    private User user;

    @Enumerated(EnumType.STRING)
    @Column(name = "blood_group",nullable = false)
    private BloodGroup bloodGroup;

    @Column(nullable = false)
    private String phone;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Gender gender;

    @Column(name = "date_of_birth",nullable = false)
    private LocalDate dateOfBirth;

    @Column(nullable = false)
    private String city;

    @Column(nullable = false)
    private String state;

    @Column(name = "last_donation_date")
    private LocalDate lastDonationDate;

    @Column(nullable = false)
    private  Boolean available;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name="updated_at")
    private LocalDateTime updatedAt;

}
