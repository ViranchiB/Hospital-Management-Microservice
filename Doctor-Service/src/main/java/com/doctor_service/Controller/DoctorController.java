package com.doctor_service.Controller;

import com.doctor_service.Entity.Doctor;
import com.doctor_service.Entity.Schedules;
import com.doctor_service.Service.DoctorService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/doctor")
public class DoctorController {

    private final DoctorService doctorService;

    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @PostMapping
    public ResponseEntity<Doctor> createDoctor(@Valid @RequestBody Doctor doctor) {
        return new ResponseEntity<>(this.doctorService.saveDoctor(doctor), HttpStatus.OK);
    }

    @GetMapping("/{doctorId}")
    public ResponseEntity<Doctor> findDoctorById(@PathVariable Long doctorId) {
        return new ResponseEntity<>(this.doctorService.findDoctorById(doctorId), HttpStatus.OK);
    }

    @PutMapping("/{doctorId}/schedule")
    public ResponseEntity<Doctor> updateDoctorSchedule(@PathVariable Long doctorId, @RequestBody Schedules updateSchedule) {
        return new ResponseEntity<>(this.doctorService.updateDoctorSchedule(doctorId, updateSchedule), HttpStatus.OK);
    }

    @GetMapping("/department/{department}")
    public ResponseEntity<List<Doctor>> getDoctorByDepartment(@PathVariable String department) {
        return new ResponseEntity<>(this.doctorService.findDoctorByDepartment(department), HttpStatus.FOUND);
    }
}
