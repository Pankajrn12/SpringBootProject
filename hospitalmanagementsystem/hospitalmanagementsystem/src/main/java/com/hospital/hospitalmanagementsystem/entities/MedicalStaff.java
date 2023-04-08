package com.hospital.hospitalmanagementsystem.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class MedicalStaff {
    @Id
    @GeneratedValue (strategy = GenerationType.SEQUENCE)
    private Long medicalStaffId;
    private String medicalStaffName;
    private String medicalStaffGender;
    private String medicalStaffDateOfBirth;
    private String medicalStaffAddress;
    private String medicalStaffContactNumber;
    private String medicalStaffEmail;

    public Long getMedicalStaffId() {
        return medicalStaffId;
    }

    public void setMedicalStaffId(Long medicalStaffId) {
        this.medicalStaffId = medicalStaffId;
    }

    public String getMedicalStaffName() {
        return medicalStaffName;
    }

    public void setMedicalStaffName(String medicalStaffName) {
        this.medicalStaffName = medicalStaffName;
    }

    public String getMedicalStaffGender() {
        return medicalStaffGender;
    }

    public void setMedicalStaffGender(String medicalStaffGender) {
        this.medicalStaffGender = medicalStaffGender;
    }

    public String getMedicalStaffDateOfBirth() {
        return medicalStaffDateOfBirth;
    }

    public void setMedicalStaffDateOfBirth(String medicalStaffDateOfBirth) {
        this.medicalStaffDateOfBirth = medicalStaffDateOfBirth;
    }

    public String getMedicalStaffAddress() {
        return medicalStaffAddress;
    }

    public void setMedicalStaffAddress(String medicalStaffAddress) {
        this.medicalStaffAddress = medicalStaffAddress;
    }

    public String getMedicalStaffContactNumber() {
        return medicalStaffContactNumber;
    }

    public void setMedicalStaffContactNumber(String medicalStaffContactNumber) {
        this.medicalStaffContactNumber = medicalStaffContactNumber;
    }

    public String getMedicalStaffEmail() {
        return medicalStaffEmail;
    }

    public void setMedicalStaffEmail(String medicalStaffEmail) {
        this.medicalStaffEmail = medicalStaffEmail;
    }
}
