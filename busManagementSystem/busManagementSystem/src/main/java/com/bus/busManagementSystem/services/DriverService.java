package com.bus.busManagementSystem.services;

import com.bus.busManagementSystem.entities.Bus;
import com.bus.busManagementSystem.entities.Driver;
import com.bus.busManagementSystem.models.BusModel;
import com.bus.busManagementSystem.models.DriverModel;
import com.bus.busManagementSystem.repositories.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class DriverService {
    @Autowired
    DriverRepository driverRepository;
    @Autowired
    EntityManager entityManager;
    public ResponseEntity saveDriverDetails(DriverModel driverModel) {
        Driver driver = new Driver();
        driver.setDriverName(driverModel.getDriverName());
        driver.setContactNumber(driverModel.getContactNumber());
        driver.setLicenseNumber(driverModel.getLicenseNumber());

        driverRepository.save(driver);
        return new ResponseEntity<>("Data Seved", HttpStatus.OK);
    }

    public ResponseEntity deleteDriverById(Long driverId) {
        driverRepository.deleteById(driverId);
        return new ResponseEntity<>("Data Deleted",HttpStatus.OK);
    }

    public ResponseEntity updateDriverById(DriverModel driverModel) {
        entityManager.createNativeQuery("update driver set contact_number =:contact_number, driver_name =:driver_name, license_number = :license_number where driver_ID=:driver_ID ")
                .setParameter("contact_number",driverModel.getContactNumber())
                .setParameter("driver_name",driverModel.getDriverName())
                .setParameter("license_number",driverModel.getLicenseNumber())
                .setParameter("driver_ID",driverModel.getDriverId()).executeUpdate();
        return new ResponseEntity<>("data Updated",HttpStatus.OK);
    }

    public List<DriverModel> getDriverDetails() {
        List<DriverModel> driverModelList = new ArrayList<>();
        List<Driver> driverList = driverRepository.findAll();
        driverList.stream().forEach(data->{
            DriverModel model = new DriverModel();
            model.setDriverId(data.getDriverId());
            model.setDriverName(data.getDriverName());
            model.setContactNumber(data.getContactNumber());
            model.setLicenseNumber(data.getLicenseNumber());
            driverModelList.add(model);
        });
        return driverModelList;
    }
}
