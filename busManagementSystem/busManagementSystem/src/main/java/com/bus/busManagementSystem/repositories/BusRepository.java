package com.bus.busManagementSystem.repositories;

import com.bus.busManagementSystem.entities.Bus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;

public interface BusRepository extends JpaRepository<Bus, Long> {
    public Bus findBusDetailsByBusId(Long busId);
}
