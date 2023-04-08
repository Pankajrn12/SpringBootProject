package com.hotelManagementsystem.hotalmanagementsystem.repositories;

import com.hotelManagementsystem.hotalmanagementsystem.entities.Booking;
import com.hotelManagementsystem.hotalmanagementsystem.modeles.BookingModel;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BookingRepository extends JpaRepository<Booking, Long> {
}
