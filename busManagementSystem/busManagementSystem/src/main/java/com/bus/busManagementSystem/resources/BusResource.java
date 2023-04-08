package com.bus.busManagementSystem.resources;

import com.bus.busManagementSystem.models.BusDriverModel;
import com.bus.busManagementSystem.models.BusModel;
import com.bus.busManagementSystem.services.BusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping("/abcd")
public class BusResource {
    @Autowired
    BusService busService;

    @Transactional
    @PostMapping("/saveBusDetails")
    public ResponseEntity saveBusDetails(@RequestBody BusModel busModel){
        return busService.saveBusDetails(busModel);
    }

    @PostMapping("/deleteBusById/{busId}")
    public ResponseEntity deleteBusById(@PathVariable("busId") Long busId){
        return busService.deleteBusById(busId);
    }
    @Transactional
    @PostMapping("/updateBusById")
    public ResponseEntity updateBusById(@RequestBody BusModel busModel){
        return busService.updateBusById(busModel);
    }
    @GetMapping("/getBusDetails")
    public List<BusModel>getBusDetails(){
        return busService.getBusDetails();
    }

    @GetMapping("/getBusDriverDetailsByBusIdDriverId/{busId}/{driverId}")
    public BusDriverModel getBusDriverDetailsByBusIdDriverId(@PathVariable ("busId") Long busId , @PathVariable("driverId") Long driverId){
        return busService.getBusDriverDetailsByBusIdDriverId(busId, driverId);
    }
}
