package com.canteen.canteenManagementSystem.repositories;

import com.canteen.canteenManagementSystem.entities.Menu;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuRepository extends JpaRepository<Menu, Long> {
}
