package com.hospital.hospitalmanagementsystem.repositories;

import com.hospital.hospitalmanagementsystem.entities.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
}
