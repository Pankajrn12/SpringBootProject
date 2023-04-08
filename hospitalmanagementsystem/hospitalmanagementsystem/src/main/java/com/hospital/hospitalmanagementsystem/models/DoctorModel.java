package com.hospital.hospitalmanagementsystem.models;

import java.util.Date;

public class DoctorModel {
    private Long doctorId;
    private String doctorName;
    private String doctorGender;
    private String doctorDateOfBirth;
    private String doctorContactNumber;
    private String doctorAddress;
    private  String doctorEmail;
    private String doctorSpeciality;

    public Long getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Long doctorId) {
        this.doctorId = doctorId;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getDoctorGender() {
        return doctorGender;
    }

    public void setDoctorGender(String doctorGender) {
        this.doctorGender = doctorGender;
    }

    public String getDoctorDateOfBirth() {
        return doctorDateOfBirth;
    }

    public void setDoctorDateOfBirth(String doctorDateOfBirth) {
        this.doctorDateOfBirth = doctorDateOfBirth;
    }

    public String getDoctorContactNumber() {
        return doctorContactNumber;
    }

    public void setDoctorContactNumber(String doctorContactNumber) {
        this.doctorContactNumber = doctorContactNumber;
    }

    public String getDoctorAddress() {
        return doctorAddress;
    }

    public void setDoctorAddress(String doctorAddress) {
        this.doctorAddress = doctorAddress;
    }

    public String getDoctorEmail() {
        return doctorEmail;
    }

    public void setDoctorEmail(String doctorEmail) {
        this.doctorEmail = doctorEmail;
    }

    public String getDoctorSpeciality() {
        return doctorSpeciality;
    }

    public void setDoctorSpeciality(String doctorSpeciality) {
        this.doctorSpeciality = doctorSpeciality;
    }

    @Override
    public String toString() {
        return "DoctorModel{" +
                "doctorId=" + doctorId +
                ", doctorName='" + doctorName + '\'' +
                ", doctorGender='" + doctorGender + '\'' +
                ", doctorDateOfBirth='" + doctorDateOfBirth + '\'' +
                ", doctorContactNumber='" + doctorContactNumber + '\'' +
                ", doctorAddress='" + doctorAddress + '\'' +
                ", doctorEmail='" + doctorEmail + '\'' +
                ", doctorSpeciality='" + doctorSpeciality + '\'' +
                '}';
    }
}
