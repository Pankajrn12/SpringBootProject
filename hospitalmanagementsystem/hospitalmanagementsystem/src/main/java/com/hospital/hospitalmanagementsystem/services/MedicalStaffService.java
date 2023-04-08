package com.hospital.hospitalmanagementsystem.services;

import com.hospital.hospitalmanagementsystem.entities.MedicalStaff;
import com.hospital.hospitalmanagementsystem.models.MedicalRecardModel;
import com.hospital.hospitalmanagementsystem.models.MedicalStaffModel;
import com.hospital.hospitalmanagementsystem.repositories.MedicalStaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

@Service
public class MedicalStaffService {
    @Autowired
    MedicalStaffRepository medicalStaffRepository;
    @Autowired
    EntityManager entityManager;

    public ResponseEntity saveMedicalStaffAllDetails(MedicalStaffModel medicalStaffModel) {
        MedicalStaff medicalStaff = new MedicalStaff();
        medicalStaff.setMedicalStaffName(medicalStaffModel.getMedicalStaffName());
        medicalStaff.setMedicalStaffGender(medicalStaffModel.getMedicalStaffGender());
        medicalStaff.setMedicalStaffContactNumber(medicalStaffModel.getMedicalStaffContactNumber());
        medicalStaff.setMedicalStaffAddress(medicalStaffModel.getMedicalStaffAddress());
        medicalStaff.setMedicalStaffEmail(medicalStaffModel.getMedicalStaffEmail());
        medicalStaff.setMedicalStaffDateOfBirth(medicalStaffModel.getMedicalStaffDateOfBirth());
        medicalStaffRepository.save(medicalStaff);
        return new ResponseEntity<>("Saved Data", HttpStatus.OK);
    }

    public ResponseEntity updateMedicalStaffById(MedicalStaffModel medicalStaffModel) {
        entityManager.createNativeQuery("update medical_staff set medical_staff_address =:medical_staff_address, medical_staff_contact_number =:medical_staff_contact_number, medical_staff_date_of_birth =:medical_staff_date_of_birth, medical_staff_email =:medical_staff_email, medical_staff_gender =:medical_staff_gender where medical_staff_id =:medical_staff_id ")
                .setParameter("medical_staff_address",medicalStaffModel.getMedicalStaffAddress())
                .setParameter("medical_staff_contact_number",medicalStaffModel.getMedicalStaffContactNumber())
                .setParameter("medical_staff_date_of_birth",medicalStaffModel.getMedicalStaffDateOfBirth())
                .setParameter("medical_staff_email",medicalStaffModel.getMedicalStaffEmail())
                .setParameter("medical_staff_gender",medicalStaffModel.getMedicalStaffGender())
                .setParameter("medical_staff_id",medicalStaffModel.getMedicalStaffId()).executeUpdate();
        return new ResponseEntity<>("data Updated",HttpStatus.OK);
    }

    public ResponseEntity deleteMedicalStaffById(Long medicalstaffId) {
        medicalStaffRepository.deleteById(medicalstaffId);
        return new ResponseEntity<>("Data deleted", HttpStatus.OK);
    }


    public List<MedicalStaffModel> getMedicalStaffDetails() {
        List<MedicalStaffModel>medicalStaffModelList = new ArrayList<>();
        List<MedicalStaff> medicalStaffList = medicalStaffRepository.findAll();
        medicalStaffList.stream().forEach(data->{
            MedicalStaffModel model = new MedicalStaffModel();
            model.setMedicalStaffId(data.getMedicalStaffId());
            model.setMedicalStaffAddress(data.getMedicalStaffAddress());
            model.setMedicalStaffDateOfBirth(data.getMedicalStaffDateOfBirth());
            model.setMedicalStaffName(data.getMedicalStaffName());
            model.setMedicalStaffGender(data.getMedicalStaffGender());
            model.setMedicalStaffContactNumber(data.getMedicalStaffContactNumber());
            model.setMedicalStaffEmail(data.getMedicalStaffEmail());

            medicalStaffModelList.add(model);
        });
        return medicalStaffModelList;
    }
}
