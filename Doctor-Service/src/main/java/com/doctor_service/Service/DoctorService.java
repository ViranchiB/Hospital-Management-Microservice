package com.doctor_service.Service;

import com.doctor_service.Entity.Doctor;
import com.doctor_service.Entity.Schedules;

import java.util.List;

public interface DoctorService {

    Doctor saveDoctor(Doctor doctor);

    Doctor findDoctorById(Long doctorId);

    Doctor updateDoctorSchedule(Long doctorId, Schedules updateSchedule);

    List<Doctor> findDoctorByDepartment(String department);
}
