package com.bus.busManagementSystem.resources;

import com.bus.busManagementSystem.models.TiketModel;
import com.bus.busManagementSystem.models.TiketPassengerModel;
import com.bus.busManagementSystem.services.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping("/abc")
public class TicketResource {
    @Autowired
    TicketService ticketService;
    @Transactional
    @PostMapping("/saveTiketDetails")
    public ResponseEntity saveTiketDetails(@RequestBody TiketModel tiketModel){
        return ticketService.saveTiketDetails(tiketModel);
    }

    @PostMapping("/deleteTiketById/{tiketId}")
    public ResponseEntity deleteTiketById (@PathVariable ("tiketId") Long tiketId){
        return ticketService.deleteTiketById(tiketId);
    }

    @Transactional
    @PostMapping("/updateTiketById")
    public ResponseEntity updateTiketById(@RequestBody TiketModel tiketModel){
        return ticketService.updateTiketById(tiketModel);
    }

    @GetMapping("/getTicketDetails")
    public List<TiketModel> getTicketDetails(){
        return ticketService.getTicketDetails();
    }

    @GetMapping("/getTiketByIdPassengerById/{tiketId}")
    public TiketPassengerModel getTiketByIdPassengerById(@PathVariable ("tiketId") Long tiketId){
        return ticketService.getTiketByIdPassengerById(tiketId);
    }
}
