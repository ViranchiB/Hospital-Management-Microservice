package com.doctor_service.Service.Impl;

import com.doctor_service.Entity.Doctor;
import com.doctor_service.Entity.Schedules;
import com.doctor_service.Exception.DoctorNotFoundException;
import com.doctor_service.Repository.DoctorRepository;
import com.doctor_service.Repository.ScheduleRepository;
import com.doctor_service.Service.DoctorService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class DoctorServiceImpl implements DoctorService {

    private final DoctorRepository doctorRepository;
    private final ScheduleRepository scheduleRepository;

    public DoctorServiceImpl(DoctorRepository doctorRepository, ScheduleRepository scheduleRepository) {
        this.doctorRepository = doctorRepository;
        this.scheduleRepository = scheduleRepository;
    }

    @Override
    public Doctor saveDoctor(Doctor doctor) {
        if (this.doctorRepository.existsDoctorByEmail(doctor.getEmail())) {
            throw new DoctorNotFoundException("Email already exists : " + doctor.getEmail());
        }
        return this.doctorRepository.save(doctor);
    }

    @Override
    public Doctor findDoctorById(Long doctorId) {
        return this.doctorRepository.findById(doctorId).orElseThrow(
                () -> new DoctorNotFoundException("Doctor not found : " + doctorId)
        );
    }

    @Override
    public Doctor updateDoctorSchedule(Long doctorId, Schedules updateSchedule) {
        Optional<Schedules> getDoctorSchedule = this.scheduleRepository.findByDoctorDoctorId(doctorId);

        if(getDoctorSchedule.isEmpty()) {
            throw new DoctorNotFoundException("Schedule not found for the Doctor : " + doctorId);
        }

        Schedules schedule = getDoctorSchedule.get();

        schedule.setDate(updateSchedule.getDate());
        schedule.setStartTime(updateSchedule.getStartTime());
        schedule.setEndTime(updateSchedule.getEndTime());

        this.scheduleRepository.save(schedule);

        return this.doctorRepository.findById(doctorId).orElseThrow(
                () -> new DoctorNotFoundException("Doctor not found : " + doctorId)
        );
    }

    @Override
    public List<Doctor> findDoctorByDepartment(String department) {
        List<Doctor> doctorByDepartment = this.doctorRepository.findDoctorByDepartment(department);

        if (doctorByDepartment.isEmpty()) {
            throw new DoctorNotFoundException("No Data found : " + department);
        }

        return doctorByDepartment;
    }

}
