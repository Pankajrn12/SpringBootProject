package com.bus.busManagementSystem.resources;

import com.bus.busManagementSystem.models.DriverModel;
import com.bus.busManagementSystem.services.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping("/xyz")
public class DriverResource {
    @Autowired
    DriverService driverService;
    @Transactional
    @PostMapping("/saveDriverDetails")
    public ResponseEntity saveDriverDetails(@RequestBody DriverModel driverModel){
        return driverService.saveDriverDetails(driverModel);
    }
    @PostMapping("/deleteDriverById/{driverId}")
    public ResponseEntity deleteDriverById(@PathVariable ("driverId") Long driverId){
        return driverService.deleteDriverById(driverId);
    }

    @Transactional
    @PostMapping("/updateDriverById")
    public ResponseEntity updateDriverById(@RequestBody DriverModel driverModel){
        return driverService.updateDriverById(driverModel);
    }

    @GetMapping("/getDriverDetails")
    public List<DriverModel> getDriverDetails(){
        return driverService.getDriverDetails();
    }

}
