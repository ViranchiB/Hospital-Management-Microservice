package com.doctor_service.Repository;

import com.doctor_service.Entity.Schedules;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedules, Long> {
    Optional<Schedules> findByDoctorDoctorId(Long doctorId);
}
