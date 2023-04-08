package com.hospital.hospitalmanagementsystem.repositories;

import com.hospital.hospitalmanagementsystem.entities.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
}
