package com.hospital.hospitalmanagementsystem.resources;

import com.hospital.hospitalmanagementsystem.entities.Appointment;
import com.hospital.hospitalmanagementsystem.models.AppointmentModel;
import com.hospital.hospitalmanagementsystem.services.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping("/hospital")
public class AppointmentResource {
    @Autowired
    AppointmentService appointmentService;

    @Transactional
    @PostMapping("/saveAppointmrntAllDetails")
    public ResponseEntity saveAppointmrntAllDetails (@RequestBody AppointmentModel appointmentModel){
        return appointmentService.saveAppointmrntAllDetails(appointmentModel);
    }
    @Transactional
    @PostMapping("/updateAppointmentById")
    public ResponseEntity updateAppointmentById(@RequestBody AppointmentModel appointmentModel){
        return appointmentService.updateAppointmentById(appointmentModel);
    }

    @PostMapping("/deleteAppointmentById/{appointmentId}")
    public ResponseEntity deleteAppointmentById(@PathVariable ("appointmentId")Long appointmentId){
        return appointmentService.deleteAppointmentById(appointmentId);
    }
    @GetMapping("/getAppointmentDetails")
    public List<AppointmentModel> getAppointmentDetails(){
        return appointmentService.getAppointmentDetails();
    }
}
