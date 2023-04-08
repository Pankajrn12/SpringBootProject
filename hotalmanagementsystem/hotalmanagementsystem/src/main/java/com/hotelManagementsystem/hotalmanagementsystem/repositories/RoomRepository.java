package com.hotelManagementsystem.hotalmanagementsystem.repositories;

import com.hotelManagementsystem.hotalmanagementsystem.entities.Room;
import com.hotelManagementsystem.hotalmanagementsystem.modeles.RoomModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoomRepository extends JpaRepository<Room, Long> {
    public Room findByRoomNumber(String roomNumber);

}
