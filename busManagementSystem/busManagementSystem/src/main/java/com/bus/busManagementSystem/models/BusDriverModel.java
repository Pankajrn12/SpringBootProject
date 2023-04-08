package com.bus.busManagementSystem.models;

public class BusDriverModel {
    private Long busId;
    private  String busName;
    private  Integer busSeat;


    private  Long driverId;
    private  String driverName;
    private String driverContactNumber;

    public Long getBusId() {
        return busId;
    }

    public void setBusId(Long busId) {
        this.busId = busId;
    }

    public String getBusName() {
        return busName;
    }

    public void setBusName(String busName) {
        this.busName = busName;
    }

    public Integer getBusSeat() {
        return busSeat;
    }

    public void setBusSeat(Integer busSeat) {
        this.busSeat = busSeat;
    }

    public Long getDriverId() {
        return driverId;
    }

    public void setDriverId(Long driverId) {
        this.driverId = driverId;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public String getDriverContactNumber() {
        return driverContactNumber;
    }

    public void setDriverContactNumber(String driverContactNumber) {
        this.driverContactNumber = driverContactNumber;
    }
}
