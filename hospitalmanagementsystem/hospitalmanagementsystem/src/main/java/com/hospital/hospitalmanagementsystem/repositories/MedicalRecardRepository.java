package com.hospital.hospitalmanagementsystem.repositories;

import com.hospital.hospitalmanagementsystem.entities.MedicalRecard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicalRecardRepository extends JpaRepository<MedicalRecard,Long> {
}
