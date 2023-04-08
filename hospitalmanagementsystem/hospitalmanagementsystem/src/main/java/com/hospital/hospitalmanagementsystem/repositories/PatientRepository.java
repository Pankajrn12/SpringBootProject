package com.hospital.hospitalmanagementsystem.repositories;

import com.hospital.hospitalmanagementsystem.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {
}
