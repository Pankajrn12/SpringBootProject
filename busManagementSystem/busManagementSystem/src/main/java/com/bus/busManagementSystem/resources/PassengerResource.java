package com.bus.busManagementSystem.resources;

import com.bus.busManagementSystem.models.PassengerModel;
import com.bus.busManagementSystem.services.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping("/abcd")
public class PassengerResource {
    @Autowired
    PassengerService passengerService;

    @Transactional
    @PostMapping("/savePassengerDetails")
    public ResponseEntity savePassengerDetails(@RequestBody PassengerModel passengerModel){
        return passengerService.savePassengerDetails(passengerModel);
    }

    @GetMapping("/getPassengerDetails")
    public List<PassengerModel> getPassengerDetails(){
        return passengerService.getPassengerDetails();
    }
    @PostMapping("/deletePassengerById/{passengerId}")
    public ResponseEntity deletePassengerById(@PathVariable("passengerId") Long passengerId){
        return passengerService.deletePassengerById(passengerId);
    }

    @Transactional
    @PostMapping("/updatePassengerById")
    public ResponseEntity updatePassengerById(@RequestBody PassengerModel passengerModel){
        return passengerService.updatePassengerById(passengerModel);
    }

}
