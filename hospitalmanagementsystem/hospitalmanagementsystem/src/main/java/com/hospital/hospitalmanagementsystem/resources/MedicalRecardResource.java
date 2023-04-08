package com.hospital.hospitalmanagementsystem.resources;

import com.hospital.hospitalmanagementsystem.models.MedicalRecardModel;
import com.hospital.hospitalmanagementsystem.services.MedicalRecardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping("/hospital")
public class MedicalRecardResource {
    @Autowired
    MedicalRecardService medicalRecardService;
    @Autowired
    EntityManager entityManager;
    @Transactional
    @PostMapping("/saveMedicalRecardAllDetails")
    public ResponseEntity saveMedicalRecardAllDetails (@RequestBody MedicalRecardModel medicalRecardModel){
        return medicalRecardService.saveMedicalRecardAllDetails(medicalRecardModel);
    }
    @Transactional
    @PostMapping("/updateMedicalRecardById")
    public ResponseEntity updateMedicalRecardById(@RequestBody MedicalRecardModel medicalRecardModel){
        entityManager.createNativeQuery("update medical_recard set appointment_id =:appointment_id , decription =:decription, diagnosis =:diagnosis, doctor_id =:doctor_id, lab_test =:lab_test, patient_id =:patient_id, treatment =:treatment where recard_id =:recard_id ")
                .setParameter("appointment_id",medicalRecardModel.getAppointmentId())
                .setParameter("decription",medicalRecardModel.getDecription())
                .setParameter("diagnosis",medicalRecardModel.getDiagnosis())
                .setParameter("doctor_id",medicalRecardModel.getDoctorId())
                .setParameter("lab_test",medicalRecardModel.getLabTest())
                .setParameter("patient_id",medicalRecardModel.getPatientId())
                .setParameter("treatment",medicalRecardModel.getTreatment())
                .setParameter("recard_id",medicalRecardModel.getRecardId()).executeUpdate();
        return new ResponseEntity<>("Data Updated", HttpStatus.OK);
    }
    @PostMapping("/deleteMedicalRecardById/{medicalRecardId}")
    public ResponseEntity deleteMedicalRecardById(@PathVariable ("medicalRecardId") Long medicalRecardId){
        return medicalRecardService.deleteMedicalRecardById(medicalRecardId);
    }

    @GetMapping("/getMedicalRecardDetails")
    public List<MedicalRecardModel> getMedicalRecardDetails(){
        return medicalRecardService.getMedicalRecardDetails();
    }

}
