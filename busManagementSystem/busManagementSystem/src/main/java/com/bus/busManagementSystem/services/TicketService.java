package com.bus.busManagementSystem.services;

import com.bus.busManagementSystem.entities.Passenger;
import com.bus.busManagementSystem.entities.Ticket;
import com.bus.busManagementSystem.models.TiketModel;
import com.bus.busManagementSystem.models.TiketPassengerModel;
import com.bus.busManagementSystem.repositories.PassengerRepository;
import com.bus.busManagementSystem.repositories.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

@Service
public class TicketService {
    @Autowired
    TicketRepository ticketRepository;
    @Autowired
    PassengerRepository passengerRepository;
    @Autowired
    EntityManager entityManager;
    public ResponseEntity saveTiketDetails(TiketModel tiketModel) {
        Ticket ticket = new Ticket();
        ticket.setSeatNumber(tiketModel.getSeatNumber());
        ticket.setScheduleId(tiketModel.getScheduleId());
        ticket.setPassengerId(tiketModel.getPassengerId());

        ticketRepository.save(ticket);
        return new ResponseEntity<>("Data Seved", HttpStatus.OK);
    }

    public ResponseEntity deleteTiketById(Long tiketId) {
        ticketRepository.deleteById(tiketId);
        return new ResponseEntity<>("Data Deleted", HttpStatus.OK);
    }

    public ResponseEntity updateTiketById(TiketModel tiketModel) {
        entityManager.createNativeQuery("update ticket set passenger_id =:passenger_id, schedule_id =:schedule_id, seat_number =:seat_number where ticket_id =:ticket_id ")
                .setParameter("passenger_id",tiketModel.getPassengerId())
                .setParameter("schedule_id",tiketModel.getScheduleId())
                .setParameter("seat_number",tiketModel.getSeatNumber())
                .setParameter("ticket_id",tiketModel.getTicketId()).executeUpdate();
        return new ResponseEntity<>("Data Updated",HttpStatus.OK);
    }

    public List<TiketModel> getTicketDetails() {
        List<TiketModel> tiketModelList = new ArrayList<>();
        List<Ticket> ticketList = ticketRepository.findAll();
        ticketList.stream().forEach(data->{
            TiketModel model = new TiketModel();
            model.setPassengerId(data.getPassengerId());
            model.setTicketId(data.getTicketId());
            model.setScheduleId(data.getScheduleId());
            model.setSeatNumber(data.getSeatNumber());

            tiketModelList.add(model);
        });
        return  tiketModelList;
    }

    public TiketPassengerModel getTiketByIdPassengerById(Long tiketId) {
        Ticket ticket= ticketRepository.findTicketDetailsByTicketId(tiketId);
        Passenger passenger= passengerRepository.findPassengerDeatilsByPassengerId(ticket.getPassengerId());
        TiketPassengerModel tiketPassengerModel = new TiketPassengerModel();
        tiketPassengerModel.setTiketId(ticket.getTicketId());
        tiketPassengerModel.setSchedulId(ticket.getScheduleId());
        tiketPassengerModel.setSeatNumber(ticket.getSeatNumber());
        tiketPassengerModel.setPassengerId(ticket.getPassengerId());
        tiketPassengerModel.setPassengerName(passenger.getPassengerName());
        tiketPassengerModel.setPassengerCantactNumber(passenger.getContactNumber());

        return  tiketPassengerModel;

    }
}
