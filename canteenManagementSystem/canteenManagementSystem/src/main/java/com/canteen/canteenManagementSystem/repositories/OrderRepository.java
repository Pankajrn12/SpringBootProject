package com.canteen.canteenManagementSystem.repositories;

import com.canteen.canteenManagementSystem.entities.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Orders,Long> {
}
