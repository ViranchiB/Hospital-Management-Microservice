package com.patient_service.Controller;

import com.patient_service.Entity.Patient;
import com.patient_service.Service.PatientService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/patients")
public class PatientController {

    private final PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @PostMapping
    public ResponseEntity<Patient> createPatient(@Valid @RequestBody Patient patient) {
        return new ResponseEntity<>(this.patientService.save(patient), HttpStatus.OK);
    }

    @GetMapping("/byId/{patientId}")
    public ResponseEntity<Patient> getPatientDetailsById(@PathVariable Long patientId) {
        return new ResponseEntity<>(this.patientService.getPatientDetailsById(patientId), HttpStatus.OK);
    }

    @PutMapping("/{patientId}")
    public ResponseEntity<Patient> updatePatient(@PathVariable Long patientId, @Valid @RequestBody Map<String, Object> patientDetails) {
        return new ResponseEntity<>(this.patientService.updatePatientDetailsById(patientId, patientDetails), HttpStatus.OK);
    }

    @GetMapping("/search/{name}")
    public ResponseEntity<Patient> getPatientDetailsByName(@PathVariable String name) {
        return new ResponseEntity<>(this.patientService.getPatientByName(name), HttpStatus.OK);
    }
}
