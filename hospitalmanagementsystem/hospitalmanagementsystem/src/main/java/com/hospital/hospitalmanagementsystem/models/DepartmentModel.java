package com.hospital.hospitalmanagementsystem.models;

public class DepartmentModel {
    private  Long departmentId;
    private String departmentName;
    private String departmentDcription;

    public Long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getDepartmentDcription() {
        return departmentDcription;
    }

    public void setDepartmentDcription(String departmentDcription) {
        this.departmentDcription = departmentDcription;
    }
}
