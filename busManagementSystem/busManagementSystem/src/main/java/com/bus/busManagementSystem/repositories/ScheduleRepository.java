package com.bus.busManagementSystem.repositories;

import com.bus.busManagementSystem.entities.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
}
