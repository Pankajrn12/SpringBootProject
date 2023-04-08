package com.bus.busManagementSystem.repositories;

import com.bus.busManagementSystem.entities.Route;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RouteRepository extends JpaRepository<Route, Long> {
}
