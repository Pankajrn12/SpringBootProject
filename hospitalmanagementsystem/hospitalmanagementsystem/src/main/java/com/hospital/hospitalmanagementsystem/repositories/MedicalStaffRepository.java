package com.hospital.hospitalmanagementsystem.repositories;

import com.hospital.hospitalmanagementsystem.entities.MedicalStaff;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicalStaffRepository extends JpaRepository<MedicalStaff, Long> {
}
