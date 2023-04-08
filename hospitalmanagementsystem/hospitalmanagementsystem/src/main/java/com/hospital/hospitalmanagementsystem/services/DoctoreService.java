package com.hospital.hospitalmanagementsystem.services;

import com.hospital.hospitalmanagementsystem.entities.Doctor;
import com.hospital.hospitalmanagementsystem.models.DoctorModel;
import com.hospital.hospitalmanagementsystem.repositories.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

@Service
public class DoctoreService {
    @Autowired
    DoctorRepository doctorRepository;
    @Autowired
    EntityManager entityManager;

    public ResponseEntity saveDoctorAllDetails(DoctorModel doctorModel) {
        System.out.println("model " +doctorModel);
        Doctor doctor = new Doctor();
        doctor.setDoctorAddress(doctorModel.getDoctorAddress());
        doctor.setDoctorContactNumber(doctorModel.getDoctorContactNumber());
        doctor.setDoctorDateOfBirth(doctorModel.getDoctorDateOfBirth());
        doctor.setDoctorEmail(doctorModel.getDoctorEmail());
        doctor.setDoctorGender(doctorModel.getDoctorGender());
        doctor.setDoctorName(doctorModel.getDoctorName());
        doctor.setDoctorSpeciality(doctorModel.getDoctorSpeciality());

        doctorRepository.save(doctor);
        return new ResponseEntity<>("data Seved", HttpStatus.OK);
    }

    public ResponseEntity updateDoctorById(DoctorModel doctorModel) {
        entityManager.createNativeQuery("update doctor set doctor_address =:doctor_address , doctor_contact_number =:doctor_contact_number , doctor_date_of_birth =:doctor_date_of_birth , doctor_email =:doctor_email , doctor_gender =:doctor_gender , doctor_name =:doctor_name , doctor_speciality =:doctor_speciality  where doctor_id =:doctor_id ")
                .setParameter("doctor_address",doctorModel.getDoctorAddress())
                .setParameter("doctor_contact_number",doctorModel.getDoctorContactNumber())
                .setParameter("doctor_date_of_birth",doctorModel.getDoctorDateOfBirth())
                .setParameter("doctor_email",doctorModel.getDoctorEmail())
                .setParameter("doctor_gender",doctorModel.getDoctorGender())
                .setParameter("doctor_name" ,doctorModel.getDoctorName())
                .setParameter("doctor_speciality",doctorModel.getDoctorSpeciality())
                .setParameter("doctor_id",doctorModel.getDoctorId()).executeUpdate();
        return new ResponseEntity<>("Data Updated",HttpStatus.OK);
    }

    public ResponseEntity deleteDoctorById(Long doctorId) {
        doctorRepository.deleteById(doctorId);
        return new ResponseEntity<>("data deleted",HttpStatus.OK);
    }

    public List<DoctorModel> getDoctorDetails() {
        List<DoctorModel>doctorModelList = new ArrayList<>();
        List<Doctor> doctorList = doctorRepository.findAll();
        doctorList.stream().forEach(data->{
            DoctorModel model = new DoctorModel();
            model.setDoctorId(data.getDoctorId());
            model.setDoctorAddress(data.getDoctorAddress());
            model.setDoctorEmail(data.getDoctorEmail());
            model.setDoctorGender(data.getDoctorGender());
            model.setDoctorName(data.getDoctorName());
            model.setDoctorSpeciality(data.getDoctorSpeciality());
            model.setDoctorContactNumber(data.getDoctorContactNumber());
            model.setDoctorDateOfBirth(data.getDoctorDateOfBirth());

            doctorModelList.add(model);
        });
        return doctorModelList;
    }
}
