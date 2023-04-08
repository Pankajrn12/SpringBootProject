package com.hospital.hospitalmanagementsystem.repositories;

import com.hospital.hospitalmanagementsystem.entities.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
}
