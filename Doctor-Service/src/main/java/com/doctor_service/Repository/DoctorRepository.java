package com.doctor_service.Repository;

import com.doctor_service.Entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long> {
    boolean existsDoctorByEmail(String email);

    List<Doctor> findDoctorByDepartment(String department);
}
