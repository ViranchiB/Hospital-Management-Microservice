package com.doctor_service.Entity;

import com.doctor_service.Entity.Enums.DoctorSpecialty;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import java.util.Set;

@Entity
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "doctorId"
)
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long doctorId;

    @NotBlank(message = "Doctor Name should not be blank")
    private String doctorName;

    @Enumerated(EnumType.STRING)
    private DoctorSpecialty specialty;

    @NotBlank(message = "Department should not be empty")
    private String department;

    @NotBlank(message = "contact should not be empty")
    private String contact;

    @Email
    @NotBlank(message = "Email should not be empty")
    private String email;

    @OneToOne(mappedBy = "doctor", cascade = CascadeType.ALL)
    private Schedules schedules;

    public Doctor() {
    }

    public Doctor(Long doctorId, String doctorName, DoctorSpecialty specialty, String department, String contact, String email, Schedules schedules) {
        this.doctorId = doctorId;
        this.doctorName = doctorName;
        this.specialty = specialty;
        this.department = department;
        this.contact = contact;
        this.email = email;
        this.schedules = schedules;
    }

    public Long getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Long doctorId) {
        this.doctorId = doctorId;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public DoctorSpecialty getSpecialty() {
        return specialty;
    }

    public void setSpecialty(DoctorSpecialty specialty) {
        this.specialty = specialty;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Schedules getSchedules() {
        return schedules;
    }

    public void setSchedules(Schedules schedules) {
        this.schedules = schedules;
    }
}