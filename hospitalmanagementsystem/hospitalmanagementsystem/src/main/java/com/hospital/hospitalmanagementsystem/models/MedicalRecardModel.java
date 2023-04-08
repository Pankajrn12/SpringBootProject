package com.hospital.hospitalmanagementsystem.models;

public class MedicalRecardModel {
    private Long recardId;

    private Long patientId;
    private Long doctorId;
    private Long appointmentId;
    private String diagnosis;
    private String treatment;
    private String labTest;
    private String decription;

    public Long getRecardId() {
        return recardId;
    }

    public void setRecardId(Long recardId) {
        this.recardId = recardId;
    }

    public Long getPatientId() {
        return patientId;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }

    public Long getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Long doctorId) {
        this.doctorId = doctorId;
    }

    public Long getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(Long appointmentId) {
        this.appointmentId = appointmentId;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public String getTreatment() {
        return treatment;
    }

    public void setTreatment(String treatment) {
        this.treatment = treatment;
    }

    public String getLabTest() {
        return labTest;
    }

    public void setLabTest(String labTest) {
        this.labTest = labTest;
    }

    public String getDecription() {
        return decription;
    }

    public void setDecription(String decription) {
        this.decription = decription;
    }
}
