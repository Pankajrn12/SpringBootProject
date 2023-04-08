package com.hotelManagementsystem.hotalmanagementsystem.modeles;

public class BookingModel {
    private Long clientId;
    private String roomNumber;
    private String inDate;
    private String outDate;

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getInDate() {
        return inDate;
    }

    public void setInDate(String inDate) {
        this.inDate = inDate;
    }

    public String getOutDate() {
        return outDate;
    }

    public void setOutDate(String outDate) {
        this.outDate = outDate;
    }

    @Override
    public String toString() {
        return "BookingModel{" +
                "clientId=" + clientId +
                ", roomNumber='" + roomNumber + '\'' +
                ", inDate='" + inDate + '\'' +
                ", outDate='" + outDate + '\'' +
                '}';
    }
}
