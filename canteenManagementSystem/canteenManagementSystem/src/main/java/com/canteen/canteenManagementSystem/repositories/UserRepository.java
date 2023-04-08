package com.canteen.canteenManagementSystem.repositories;

import com.canteen.canteenManagementSystem.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
