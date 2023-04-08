package com.bus.busManagementSystem.repositories;

import com.bus.busManagementSystem.entities.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket, Long> {
    public Ticket findTicketDetailsByTicketId(Long ticketId);
}
