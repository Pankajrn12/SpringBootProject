package com.bus.busManagementSystem.repositories;

import com.bus.busManagementSystem.entities.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PassengerRepository extends JpaRepository<Passenger, Long> {
    public Passenger findPassengerDeatilsByPassengerId(Long passengerId);
}
