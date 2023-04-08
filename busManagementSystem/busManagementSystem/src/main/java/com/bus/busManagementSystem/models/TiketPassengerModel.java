package com.bus.busManagementSystem.models;

public class TiketPassengerModel {
    private Long tiketId;
    private Long passengerId;
    private Long schedulId;
    private  Integer seatNumber;

    private String passengerName;
    private String passengerCantactNumber;

    public Long getTiketId() {
        return tiketId;
    }

    public void setTiketId(Long tiketId) {
        this.tiketId = tiketId;
    }

    public Long getPassengerId() {
        return passengerId;
    }

    public void setPassengerId(Long passengerId) {
        this.passengerId = passengerId;
    }

    public Long getSchedulId() {
        return schedulId;
    }

    public void setSchedulId(Long schedulId) {
        this.schedulId = schedulId;
    }

    public Integer getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(Integer seatNumber) {
        this.seatNumber = seatNumber;
    }

    public String getPassengerName() {
        return passengerName;
    }

    public void setPassengerName(String passengerName) {
        this.passengerName = passengerName;
    }

    public String getPassengerCantactNumber() {
        return passengerCantactNumber;
    }

    public void setPassengerCantactNumber(String passengerCantactNumber) {
        this.passengerCantactNumber = passengerCantactNumber;
    }
}
