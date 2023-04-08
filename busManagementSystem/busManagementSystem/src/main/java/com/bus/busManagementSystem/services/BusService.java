package com.bus.busManagementSystem.services;

import com.bus.busManagementSystem.entities.Bus;
import com.bus.busManagementSystem.entities.Driver;
import com.bus.busManagementSystem.models.BusDriverModel;
import com.bus.busManagementSystem.models.BusModel;
import com.bus.busManagementSystem.repositories.BusRepository;
import com.bus.busManagementSystem.repositories.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BusService {
    @Autowired
    BusRepository busRepository;
    @Autowired
    DriverRepository driverRepository;
    @Autowired
    EntityManager entityManager;
    public ResponseEntity saveBusDetails(BusModel busModel) {
        Bus bus = new Bus();
        bus.setName(busModel.getName());
        bus.setSeats(busModel.getSeats());

        busRepository.save(bus);
        return new ResponseEntity<>("Data Seved", HttpStatus.OK);
    }

    public ResponseEntity deleteBusById(Long busId) {
        busRepository.deleteById(busId);
        return new ResponseEntity<>("Data Deleted", HttpStatus.OK);
    }

    public ResponseEntity updateBusById(BusModel busModel) {
        entityManager.createNativeQuery("update bus set seats =:seats, name =:name where bus_id=:bus_id ")
                .setParameter("seats",busModel.getSeats())
                .setParameter("name",busModel.getName())
                .setParameter("bus_id",busModel.getBusId()).executeUpdate();
        return new ResponseEntity<>("Data Updated",HttpStatus.OK);
    }

    public List<BusModel> getBusDetails() {
        List<BusModel>busModelList = new ArrayList<>();
        List<Bus> busList = busRepository.findAll();
        busList.stream().forEach(data->{
            BusModel model = new BusModel();
            model.setBusId(data.getBusId());
            model.setName(data.getName());
            model.setSeats(data.getSeats());
            busModelList.add(model);
        });
        return busModelList;

    }

    public BusDriverModel getBusDriverDetailsByBusIdDriverId(Long busId, Long driverId){
        Bus bus = busRepository.findBusDetailsByBusId(busId);
        Driver driver = driverRepository.findDriverDetailsByDriverId(driverId);
        BusDriverModel busDriverModel = new BusDriverModel();
        busDriverModel.setBusId(bus.getBusId());
        busDriverModel.setBusName(bus.getName());
        busDriverModel.setBusSeat(bus.getSeats());
        busDriverModel.setDriverId(driver.getDriverId());
        busDriverModel.setDriverName(driver.getDriverName());
        busDriverModel.setDriverContactNumber(driver.getContactNumber());
        return busDriverModel;

    }
}
