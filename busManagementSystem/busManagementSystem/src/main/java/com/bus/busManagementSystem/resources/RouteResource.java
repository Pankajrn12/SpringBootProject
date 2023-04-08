package com.bus.busManagementSystem.resources;

import com.bus.busManagementSystem.entities.Route;
import com.bus.busManagementSystem.models.RoutModel;
import com.bus.busManagementSystem.services.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/abc")
public class RouteResource {
    @Autowired
    RouteService routeService;
    @Transactional
    @PostMapping("/saveRoutDetails")
    public ResponseEntity saveRoutDetails(@RequestBody RoutModel routModel){
        return routeService.saveRoutDetails(routModel);
    }

    @PostMapping("/deleteRoutById/{routId}")
    public ResponseEntity deleteRoutById(@PathVariable ("routId") Long routId){
        return routeService.deleteRoutById(routId);
    }

    @Transactional
    @PostMapping("/updatedRoutBYId")
    public ResponseEntity updatedRoutBYId(@RequestBody RoutModel routModel){
        return routeService.updatedRoutBYId(routModel);
    }

    @GetMapping("/getRoutDetails")
    public List<RoutModel> getRoutDetails(){
        return routeService.getRoutDetails();
    }
}
