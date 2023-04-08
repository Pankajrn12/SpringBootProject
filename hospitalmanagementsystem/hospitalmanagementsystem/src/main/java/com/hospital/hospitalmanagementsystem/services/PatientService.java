package com.hospital.hospitalmanagementsystem.services;

import com.hospital.hospitalmanagementsystem.entities.Patient;
import com.hospital.hospitalmanagementsystem.models.PatientModel;
import com.hospital.hospitalmanagementsystem.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

@Service
public class PatientService {
    @Autowired
    PatientRepository patientRepository;

    @Autowired
    EntityManager entityManager;

    public ResponseEntity savePatientAllDetails(PatientModel patientModel) {

        Patient patient = new Patient();
        patient.setPatientName(patientModel.getPatientName());
        patient.setPatientGender(patientModel.getPatientGender());
        patient.setPatientEmail(patientModel.getPatientEmail());
        patient.setPatientAddress(patientModel.getPatientAddress());
        patient.setPatientContactNumber(patientModel.getPatientContactNumber());
        patient.setPatientDateOfBirth(patientModel.getPatientDateOfBirth());
        patientRepository.save(patient);
        return new ResponseEntity<>("Saved Data", HttpStatus.OK);
    }

    public ResponseEntity updatePatientById(PatientModel patientModel) {
        entityManager.createNativeQuery("update patient set patient_address =:patient_address , patient_contact_number =:patient_contact_number , patient_date_of_birth =:patient_date_of_birth , patient_email =:patient_email , patient_gender =patient_gender , patient_name =:patient_name where patient_id =:patient_id ")
                .setParameter("patient_address",patientModel.getPatientAddress())
                .setParameter("patient_contact_number",patientModel.getPatientContactNumber())
                .setParameter("patient_date_of_birth",patientModel.getPatientDateOfBirth())
                .setParameter("patient_email",patientModel.getPatientEmail())
                .setParameter("patient_gender",patientModel.getPatientGender())
                .setParameter("patient_name",patientModel.getPatientName())
                .setParameter("patient_id",patientModel.getPatientId()).executeUpdate();
        return new ResponseEntity<>("Updated Data",HttpStatus.OK);
    }

    public ResponseEntity deletePatientById(Long patientId) {
        patientRepository.deleteById(patientId);
        return new ResponseEntity<>("data Deleted",HttpStatus.OK);
    }

    public List<PatientModel> getPatientDetails() {
        List<PatientModel> patientModelList = new ArrayList<>();
        List<Patient> patientList = patientRepository.findAll();
        patientList.stream().forEach(data->{
            PatientModel model = new PatientModel();
            model.setPatientId(data.getPatientId());
            model.setPatientAddress(data.getPatientAddress());
            model.setPatientEmail(data.getPatientEmail());
            model.setPatientGender(data.getPatientGender());
            model.setPatientName(data.getPatientName());
            model.setPatientContactNumber(data.getPatientContactNumber());
            model.setPatientDateOfBirth(data.getPatientDateOfBirth());

            patientModelList.add(model);
        });
        return patientModelList;
    }
}
