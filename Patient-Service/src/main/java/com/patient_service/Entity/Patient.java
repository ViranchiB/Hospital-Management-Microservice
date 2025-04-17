package com.patient_service.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long patientId;

    @NotBlank(message = "Name should not be blank")
    private String name;

    @NotNull(message = "DOB should not be empty")
    private LocalDate dob;

    private String gender;

    @NotBlank(message = "Contact Number should not be empty")
    private String contact;

    @NotBlank(message = "Address should not be empty")
    private String address;

    @Email
    @NotBlank(message = "Email should not be empty")
    private String email;

    @CreationTimestamp
    private LocalDateTime createdAt;

    private Long insuranceId;

    public Patient() {
    }

    // WITHOUT INSURANCE
    public Patient(LocalDateTime createdAt, String email, String address, String contact, String gender, LocalDate dob, String name, Long patientId) {
        this.createdAt = createdAt;
        this.email = email;
        this.address = address;
        this.contact = contact;
        this.gender = gender;
        this.dob = dob;
        this.name = name;
        this.patientId = patientId;
    }

    // WITH INSURANCE
    public Patient(Long patientId, String name, LocalDate dob, String gender, String contact, String address, String email, LocalDateTime createdAt, Long insuranceId) {
        this.patientId = patientId;
        this.name = name;
        this.dob = dob;
        this.gender = gender;
        this.contact = contact;
        this.address = address;
        this.email = email;
        this.createdAt = createdAt;
        this.insuranceId = insuranceId;
    }

    public Long getPatientId() {
        return patientId;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }

    public @NotBlank(message = "Name should not be blank") String getName() {
        return name;
    }

    public void setName(@NotBlank(message = "Name should not be blank") String name) {
        this.name = name;
    }

    public @NotNull(message = "DOB should not be empty") LocalDate getDob() {
        return dob;
    }

    public void setDob(@NotNull(message = "DOB should not be empty") LocalDate dob) {
        this.dob = dob;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public @NotBlank(message = "Contact Number should not be empty") String getContact() {
        return contact;
    }

    public void setContact(@NotBlank(message = "Contact Number should not be empty") String contact) {
        this.contact = contact;
    }

    public @NotBlank(message = "Address should not be empty") String getAddress() {
        return address;
    }

    public void setAddress(@NotBlank(message = "Address should not be empty") String address) {
        this.address = address;
    }

    public @Email @NotBlank(message = "Email should not be empty") String getEmail() {
        return email;
    }

    public void setEmail(@Email @NotBlank(message = "Email should not be empty") String email) {
        this.email = email;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public Long getInsuranceId() {
        return insuranceId;
    }

    public void setInsuranceId(Long insuranceId) {
        this.insuranceId = insuranceId;
    }
}
