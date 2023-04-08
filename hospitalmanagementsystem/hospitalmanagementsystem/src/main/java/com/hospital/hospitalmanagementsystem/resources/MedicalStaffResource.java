package com.hospital.hospitalmanagementsystem.resources;

import com.hospital.hospitalmanagementsystem.models.MedicalRecardModel;
import com.hospital.hospitalmanagementsystem.models.MedicalStaffModel;
import com.hospital.hospitalmanagementsystem.services.MedicalStaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;


@RestController
@RequestMapping("/hospital")
public class MedicalStaffResource {
    @Autowired
    MedicalStaffService medicalStaffService;


    @Transactional
    @PostMapping("/saveMedicalStaffAllDetails")
    public ResponseEntity saveMedicalStaffAllDetails(@RequestBody MedicalStaffModel medicalStaffModel){
        return medicalStaffService.saveMedicalStaffAllDetails(medicalStaffModel);
    }
    @Transactional
    @PostMapping("/updateMedicalStaffById")
    public ResponseEntity updateMedicalStaffById (@RequestBody MedicalStaffModel medicalStaffModel){
        return medicalStaffService.updateMedicalStaffById(medicalStaffModel);
    }
    @PostMapping("/deleteMedicalStaffById/{medicalstaffId}")
    public ResponseEntity deleteMedicalStaffById(@PathVariable ("medicalstaffId") Long medicalstaffId){
        return medicalStaffService.deleteMedicalStaffById(medicalstaffId);
    }
    @GetMapping("/getMedicalStaffDetails")
    public List<MedicalStaffModel> getMedicalStaffDetails(){
        return medicalStaffService.getMedicalStaffDetails();
    }
}
