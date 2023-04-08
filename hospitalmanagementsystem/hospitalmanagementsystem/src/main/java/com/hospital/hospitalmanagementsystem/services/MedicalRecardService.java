package com.hospital.hospitalmanagementsystem.services;

import com.hospital.hospitalmanagementsystem.entities.MedicalRecard;
import com.hospital.hospitalmanagementsystem.models.MedicalRecardModel;
import com.hospital.hospitalmanagementsystem.repositories.MedicalRecardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MedicalRecardService {
    @Autowired
    MedicalRecardRepository medicalRecardRepository;

    public ResponseEntity saveMedicalRecardAllDetails(MedicalRecardModel medicalRecardModel) {
        MedicalRecard medicalRecard = new MedicalRecard();
        medicalRecard.setDecription(medicalRecardModel.getDecription());
        medicalRecard.setAppointmentId(medicalRecardModel.getAppointmentId());
        medicalRecard.setDiagnosis(medicalRecardModel.getDiagnosis());
        medicalRecard.setDoctorId(medicalRecardModel.getDoctorId());
        medicalRecard.setPatientId(medicalRecardModel.getPatientId());
        medicalRecard.setLabTest(medicalRecardModel.getLabTest());
        medicalRecard.setTreatment(medicalRecardModel.getTreatment());

        medicalRecardRepository.save(medicalRecard);
        return new ResponseEntity<>("Data seved", HttpStatus.OK);

    }

    public ResponseEntity deleteMedicalRecardById(Long medicalRecardId) {
        medicalRecardRepository.deleteById(medicalRecardId);
        return new ResponseEntity<>("data deleted",HttpStatus.OK);
    }

    public List<MedicalRecardModel> getMedicalRecardDetails() {
        List<MedicalRecardModel>medicalRecardModelList = new ArrayList<>();
        List<MedicalRecard>medicalRecardList = medicalRecardRepository.findAll();
        medicalRecardList.stream().forEach(data->{
            MedicalRecardModel model = new MedicalRecardModel();
            model.setAppointmentId(data.getAppointmentId());
            model.setDecription(data.getDecription());
            model.setRecardId(data.getRecardId());
            model.setTreatment(data.getTreatment());
            model.setLabTest(data.getLabTest());
            model.setDiagnosis(data.getDiagnosis());
            model.setPatientId(data.getPatientId());

            medicalRecardModelList.add(model);
        });
        return medicalRecardModelList;
    }
}
