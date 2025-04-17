package com.patient_service.Service;

import com.patient_service.Entity.Patient;

import java.util.Map;

public interface PatientService {

    Patient save(Patient patient);

    Patient getPatientDetailsById(Long patientId);

    Patient updatePatientDetailsById(Long patientId, Map<String, Object> patientDetails);

    Patient getPatientByName(String patientName);
}
