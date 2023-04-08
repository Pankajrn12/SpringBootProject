package com.bus.busManagementSystem.repositories;

import com.bus.busManagementSystem.entities.Driver;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DriverRepository extends JpaRepository<Driver, Long> {
    public Driver findDriverDetailsByDriverId(Long driverId);
}
