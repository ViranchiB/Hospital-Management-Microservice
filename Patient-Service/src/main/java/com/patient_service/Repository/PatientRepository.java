package com.patient_service.Repository;

import com.patient_service.Entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {
    boolean existsByEmail(String email);
    boolean existsById(Long patientId);
    Optional<Patient> findPatientByName(String name);
}
