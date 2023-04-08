package com.bus.busManagementSystem.services;

import com.bus.busManagementSystem.entities.Passenger;
import com.bus.busManagementSystem.models.PassengerModel;
import com.bus.busManagementSystem.repositories.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PassengerService {
    @Autowired
    PassengerRepository passengerRepository;
    @Autowired
    EntityManager entityManager;
    public ResponseEntity savePassengerDetails(PassengerModel passengerModel) {
        Passenger passenger = new Passenger();
        passenger.setPassengerName(passengerModel.getPassengerName());
        passenger.setContactNumber(passengerModel.getContactNumber());

        passengerRepository.save(passenger);
        return new ResponseEntity<>("Data is Inserted", HttpStatus.OK);
    }


    public List<PassengerModel> getPassengerDetails() {
        List<PassengerModel> passengerModelList = new ArrayList<>();
        List<Passenger> passengerList = passengerRepository.findAll();
        passengerList.stream().forEach(data->{
            PassengerModel model = new PassengerModel();
            model.setPassengerId(data.getPassengerId());
            model.setPassengerName(data.getPassengerName());
            model.setContactNumber(data.getContactNumber());
            passengerModelList.add(model);
        });
        return passengerModelList;
    }


    public ResponseEntity deletePassengerById(Long passengerId) {
        passengerRepository.deleteById(passengerId);
        return  new ResponseEntity<>("Data Deleted",HttpStatus.OK);

    }

    public ResponseEntity updatePassengerById(PassengerModel passengerModel) {
        entityManager.createNativeQuery("update passenger set contact_number =:contact_number, passenger_name =:passenger_name where passenger_id=:passenger_id ")
                .setParameter("contact_number",passengerModel.getContactNumber())
                .setParameter("passenger_name",passengerModel.getPassengerName())
                .setParameter("passenger_id",passengerModel.getPassengerId()).executeUpdate();
        return new ResponseEntity<>("Data Updated",HttpStatus.OK);

    }
}
