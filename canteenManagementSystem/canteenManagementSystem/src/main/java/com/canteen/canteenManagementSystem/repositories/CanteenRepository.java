package com.canteen.canteenManagementSystem.repositories;

import com.canteen.canteenManagementSystem.entities.Canteen;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CanteenRepository extends JpaRepository<Canteen, Long> {
}
