package com.hospital.hospitalmanagementsystem.services;

import com.hospital.hospitalmanagementsystem.entities.Appointment;
import com.hospital.hospitalmanagementsystem.models.AppointmentModel;
import com.hospital.hospitalmanagementsystem.repositories.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

@Service
public class AppointmentService {
    @Autowired
    AppointmentRepository appointmentRepository;
    @Autowired
    EntityManager entityManager;

    public ResponseEntity saveAppointmrntAllDetails(AppointmentModel appointmentModel) {
        Appointment appointment = new Appointment();
        appointment.setPatientId(appointmentModel.getPatientId());
        appointment.setDoctorId(appointmentModel.getDoctorId());
        appointment.setAppointmentDate(appointmentModel.getAppointmentDate());
        appointment.setAppointmentReason(appointmentModel.getAppointmentReason());

        appointmentRepository.save(appointment);
        return new ResponseEntity<>("Data saved", HttpStatus.OK);
    }

    public ResponseEntity updateAppointmentById(AppointmentModel appointmentModel) {
        entityManager.createNativeQuery("update appointment set appointment_date =:appointment_date , appointment_reason =:appointment_reason , doctor_id =:doctor_id , patient_id =:patient_id where appointment_id =:appointment_id ")
                .setParameter("appointment_date",appointmentModel.getAppointmentDate())
                .setParameter("appointment_reason",appointmentModel.getAppointmentReason())
                .setParameter("doctor_id",appointmentModel.getDoctorId())
                .setParameter("patient_id",appointmentModel.getPatientId())
                .setParameter("appointment_id",appointmentModel.getAppointmentId()).executeUpdate();
        return new ResponseEntity<>("Date updated",HttpStatus.OK);
    }

    public ResponseEntity deleteAppointmentById(Long appointmentId) {
        appointmentRepository.deleteById(appointmentId);
        return new ResponseEntity<>("Data Deleted",HttpStatus.OK);
    }

    public List<AppointmentModel> getAppointmentDetails() {
        List<AppointmentModel>appointmentModelList = new ArrayList<>();
        List<Appointment> appointmentList = appointmentRepository.findAll();
        appointmentList.stream().forEach(data->{
            AppointmentModel model = new AppointmentModel();
            model.setAppointmentId(data.getAppointmentId());
            model.setAppointmentDate(data.getAppointmentDate());
            model.setAppointmentReason(data.getAppointmentReason());
            model.setDoctorId(data.getDoctorId());
            model.setPatientId(data.getPatientId());

            appointmentModelList.add(model);
        });
        return appointmentModelList;
    }
}
