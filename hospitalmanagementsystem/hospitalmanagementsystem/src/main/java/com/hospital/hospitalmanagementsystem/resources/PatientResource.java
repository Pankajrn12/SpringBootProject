package com.hospital.hospitalmanagementsystem.resources;

import com.hospital.hospitalmanagementsystem.models.PatientModel;
import com.hospital.hospitalmanagementsystem.services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping("/hospital")
public class PatientResource {
    @Autowired
    PatientService patientService;
    @Transactional
    @PostMapping("/savePatientAllDetails")
    public ResponseEntity savePatientAllDetails(@RequestBody PatientModel patientModel){
        return patientService.savePatientAllDetails(patientModel);
    }
    @Transactional
    @PostMapping("/updatePatientById")
    public ResponseEntity updatePatientById(@RequestBody PatientModel patientModel){
        return patientService.updatePatientById(patientModel);
    }
    @PostMapping("/deletePatientById/{patientId}")
    public ResponseEntity deletePatientById(@PathVariable ("patientId") Long patientId){
        return patientService.deletePatientById(patientId);
    }
    @GetMapping("/getPatientDetails")
    public List<PatientModel> getPatientDetails(){
        return patientService.getPatientDetails();
    }
}
