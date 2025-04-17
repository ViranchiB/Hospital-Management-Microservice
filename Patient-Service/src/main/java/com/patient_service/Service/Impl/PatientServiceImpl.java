package com.patient_service.Service.Impl;

import com.patient_service.Entity.Patient;
import com.patient_service.Exception.PatientNotFoundException;
import com.patient_service.Repository.PatientRepository;
import com.patient_service.Service.PatientService;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.Map;
import java.util.Optional;

@Service
public class PatientServiceImpl implements PatientService {

    private final PatientRepository patientRepository;

    public PatientServiceImpl(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }


    @Override
    public Patient save(Patient patient) {
        if(this.patientRepository.existsByEmail(patient.getEmail())) {
            throw new PatientNotFoundException("Email already exists : " + patient.getEmail());
        }
        return this.patientRepository.save(patient);
    }

    @Override
    public Patient getPatientDetailsById(Long patientId) {
        return this.patientRepository.findById(patientId).orElseThrow(
                () -> new PatientNotFoundException("Patient not found : " + patientId)
        );
    }

    @Override
    public Patient updatePatientDetailsById(Long patientId, Map<String, Object> patientDetails) {
        if(!this.patientRepository.existsById(patientId)) {
            throw new PatientNotFoundException("Patient not found : " + patientId);
        }

        Patient patient = this.patientRepository.findById(patientId).orElseThrow();

        patientDetails.forEach((field, value) -> {
            Field fieldToUpdate = ReflectionUtils.findField(Patient.class, field);
            assert fieldToUpdate != null;
            fieldToUpdate.setAccessible(true);
            ReflectionUtils.setField(fieldToUpdate, patient, value);
        });

        return this.patientRepository.save(patient);
    }


    @Override
    public Patient getPatientByName(String patientName) {
        Optional<Patient> patientByName = this.patientRepository.findPatientByName(patientName);

        if(patientByName.isPresent()) {
            return patientByName.get();
        }else
            throw new PatientNotFoundException("Patient not found by Name " + patientName);
    }
}
