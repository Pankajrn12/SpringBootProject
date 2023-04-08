package com.canteen.canteenManagementSystem.models;

public class CanteenModel {
    private Long canteenId;
    private String canteenName;
    private String canteenAddress;
    private String canteenContactNumber;
    private String canteenEmailId;

    public Long getCanteenId() {
        return canteenId;
    }

    public void setCanteenId(Long canteenId) {
        this.canteenId = canteenId;
    }

    public String getCanteenName() {
        return canteenName;
    }

    public void setCanteenName(String canteenName) {
        this.canteenName = canteenName;
    }

    public String getCanteenAddress() {
        return canteenAddress;
    }

    public void setCanteenAddress(String canteenAddress) {
        this.canteenAddress = canteenAddress;
    }

    public String getCanteenContactNumber() {
        return canteenContactNumber;
    }

    public void setCanteenContactNumber(String canteenContactNumber) {
        this.canteenContactNumber = canteenContactNumber;
    }

    public String getCanteenEmailId() {
        return canteenEmailId;
    }

    public void setCanteenEmailId(String canteenEmailId) {
        this.canteenEmailId = canteenEmailId;
    }
}
