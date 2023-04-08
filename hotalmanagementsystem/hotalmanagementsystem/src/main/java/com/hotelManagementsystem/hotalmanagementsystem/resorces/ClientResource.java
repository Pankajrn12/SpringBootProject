package com.hotelManagementsystem.hotalmanagementsystem.resorces;

import com.hotelManagementsystem.hotalmanagementsystem.modeles.BookingModel;
import com.hotelManagementsystem.hotalmanagementsystem.modeles.ClientModel;
import com.hotelManagementsystem.hotalmanagementsystem.modeles.RoomModel;
import com.hotelManagementsystem.hotalmanagementsystem.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/hotel")
public class ClientResource {
    @Autowired
    ClientService clientService;



    @PostMapping("/saveClientDetails")
    public ResponseEntity saveClientDetails (@RequestBody ClientModel clientModel){
        return clientService.saveClientDetails(clientModel);
    }
    @PostMapping("/saveRoomDetails")
    public ResponseEntity saveRoomDetails(@RequestBody RoomModel roomModel){
        return clientService.saveRoomDetails(roomModel);
    }

    @GetMapping("/getRoomDetails")
    public List<RoomModel> getRoomDetails(){
        return clientService.getRoomDetails();
    }

    @PostMapping("/saveBookingDetails")
    public ResponseEntity saveBookingDetails(@RequestBody BookingModel bookingModel){
        return  clientService.saveBookingDetails(bookingModel);
    }
    @GetMapping("/getAvailableRoom")
    public List<RoomModel>getAvailableRoom(){
        return clientService.getAvailableRoom();
    }
}
