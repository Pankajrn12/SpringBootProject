package com.canteen.canteenManagementSystem.repositories;

import com.canteen.canteenManagementSystem.entities.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem,Long> {
}
