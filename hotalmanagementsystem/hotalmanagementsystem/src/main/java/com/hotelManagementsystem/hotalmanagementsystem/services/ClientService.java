package com.hotelManagementsystem.hotalmanagementsystem.services;

import com.hotelManagementsystem.hotalmanagementsystem.entities.Booking;
import com.hotelManagementsystem.hotalmanagementsystem.entities.Client;
import com.hotelManagementsystem.hotalmanagementsystem.entities.Room;
import com.hotelManagementsystem.hotalmanagementsystem.modeles.BookingModel;
import com.hotelManagementsystem.hotalmanagementsystem.modeles.ClientModel;
import com.hotelManagementsystem.hotalmanagementsystem.modeles.RoomModel;
import com.hotelManagementsystem.hotalmanagementsystem.repositories.BookingRepository;
import com.hotelManagementsystem.hotalmanagementsystem.repositories.ClientRepository;
import com.hotelManagementsystem.hotalmanagementsystem.repositories.RoomRepository;
import com.hotelManagementsystem.hotalmanagementsystem.status.AvailabilityStatus;
import com.hotelManagementsystem.hotalmanagementsystem.utility.DateUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Status;
import javax.transaction.Transactional;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class ClientService {
    @Autowired
    ClientRepository clientRepository;

    @Autowired
    RoomRepository roomRepository;
    @Autowired
    BookingRepository bookingRepository;

    @Transactional
    public ResponseEntity saveClientDetails(ClientModel clientModel) {
        Client client = new Client();
        client.setClientId(clientModel.getClientId());
        client.setClientAddress(clientModel.getClientAddress());
        client.setClientName(clientModel.getClientName());
        client.setClientMobileNumber(clientModel.getClientMobileNumber());
        client.setClientAadharNumber(clientModel.getClientAadharNumber());
        client.setCreationDate(DateUtility.getCurrentDate());


        clientRepository.save(client);
        return new ResponseEntity<>("Data saved", HttpStatus.OK);
    }

    public ResponseEntity saveRoomDetails(RoomModel roomModel) {
        Room room = new Room();
        room.setRoomId(roomModel.getRoomId());
        room.setDescription(roomModel.getDescription());
        room.setFlor(roomModel.getFlor());
        room.setRoomNumber(roomModel.getRoomNumber());
        if(roomModel.getStatus().equalsIgnoreCase("Available")) {
            room.setStatus(AvailabilityStatus.Available);
        }
        else if (roomModel.getStatus().equalsIgnoreCase("Booked")){
            room.setStatus(AvailabilityStatus.Booked);
        }

        roomRepository.save(room);
        return new ResponseEntity<>("Data Saved",HttpStatus.OK);
    }

    public List<RoomModel> getRoomDetails() {
        List<RoomModel> roomModelList = new ArrayList<>();
        List<Room> roomList = roomRepository.findAll();
        roomList.stream().forEach(data->{
            RoomModel model = new RoomModel();
            model.setRoomId(data.getRoomId());
            model.setRoomNumber(data.getRoomNumber());
            model.setFlor(data.getFlor());
            model.setDescription(data.getDescription());
            model.setStatus(data.getStatus().toString());

            roomModelList.add(model);
        });
        return roomModelList;
    }

    public ResponseEntity saveBookingDetails(BookingModel bookingModel) {
//        Date date = Calendar.getInstance().getTime();
//        DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
//        String strDate = dateFormat.format(date);

        Client client = clientRepository.findByClientId(bookingModel.getClientId());
        System.out.println("client    ********** "+client);
        Room room = roomRepository.findByRoomNumber(bookingModel.getRoomNumber());
        System.out.println("Room ***************** "+room);
        room.setStatus(AvailabilityStatus.Booked);
        roomRepository.save(room);
        System.out.println("Room Details After Save************"+room);

        Booking booking = new Booking();
        booking.setClientId(client.getClientId().toString());
        booking.setClientAddress(client.getClientAddress());
        booking.setClientName(client.getClientName());
        booking.setClientAadharNumber(client.getClientAadharNumber());
        booking.setClientMobileNumber(client.getClientMobileNumber());
        booking.setInDate(DateUtility.getCurrentDate());
        booking.setOutDate(bookingModel.getOutDate());

        booking.setRoomDescription(room.getDescription());
        booking.setRoomNumber(room.getRoomNumber());
        booking.setStatus(AvailabilityStatus.Booked);


        bookingRepository.save(booking);

        System.out.println("Booking After Save *********************** "+booking);

        return new ResponseEntity<>("Data Saved", HttpStatus.OK);
    }

    public List<RoomModel> getAvailableRoom() {
        List<RoomModel> roomModelList = new ArrayList<>();
        List<Room> roomList = roomRepository.findAll();
        roomList.stream().forEach(data-> {

            RoomModel model = null;
            if (data.getStatus().toString().equalsIgnoreCase("Available")) {
                model = new RoomModel();
                model.setRoomId(data.getRoomId());
                model.setDescription(data.getDescription());
                model.setRoomNumber(data.getRoomNumber());
                model.setFlor(data.getFlor());
                model.setStatus(data.getStatus().toString());

                roomModelList.add(model);
            }


        });
        return roomModelList;

    }
}
