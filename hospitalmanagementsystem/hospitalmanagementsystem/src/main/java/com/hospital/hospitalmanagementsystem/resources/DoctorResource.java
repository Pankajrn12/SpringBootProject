package com.hospital.hospitalmanagementsystem.resources;

import com.hospital.hospitalmanagementsystem.models.DoctorModel;
import com.hospital.hospitalmanagementsystem.services.DoctoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping("/hospital")
public class DoctorResource {
    @Autowired
    DoctoreService doctoreService;
    @Autowired
    EntityManager entityManager;

    @Transactional
    @PostMapping("/saveDoctorAllDetails")
    public ResponseEntity saveDoctorAllDetails(@RequestBody DoctorModel doctorModel){
        return doctoreService.saveDoctorAllDetails(doctorModel);
    }
    @Transactional
    @PostMapping("/updateDoctorById")
    public ResponseEntity updateDoctorById(@RequestBody DoctorModel doctorModel){
        return doctoreService.updateDoctorById(doctorModel);
    }
    @PostMapping("/deleteDoctorById/{doctorId}")
    public ResponseEntity deleteDoctorById(@PathVariable ("doctorId") Long doctorId){
        return doctoreService.deleteDoctorById(doctorId);
    }
    @GetMapping("/getDoctorDetails")
    public List<DoctorModel>getDoctorDetails(){
        return doctoreService.getDoctorDetails();
    }
}
