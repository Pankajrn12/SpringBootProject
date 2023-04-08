package com.hotelManagementsystem.hotalmanagementsystem.entities;

import com.hotelManagementsystem.hotalmanagementsystem.status.AvailabilityStatus;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long bookingId;
    private String clientName;
    private String clientAddress;
    private String clientMobileNumber;
    private String clientAadharNumber;
    private String clientId;
    private Date inDate;
    private String outDate;
    @Enumerated(EnumType.STRING)
    private AvailabilityStatus status;

    private String roomNumber;
    private String roomDescription;


    public Long getBookingId() {
        return bookingId;
    }

    public void setBookingId(Long bookingId) {
        this.bookingId = bookingId;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getClientAddress() {
        return clientAddress;
    }

    public void setClientAddress(String clientAddress) {
        this.clientAddress = clientAddress;
    }

    public String getClientMobileNumber() {
        return clientMobileNumber;
    }

    public void setClientMobileNumber(String clientMobileNumber) {
        this.clientMobileNumber = clientMobileNumber;
    }

    public String getClientAadharNumber() {
        return clientAadharNumber;
    }

    public void setClientAadharNumber(String clientAadharNumber) {
        this.clientAadharNumber = clientAadharNumber;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public Date getInDate() {
        return inDate;
    }

    public void setInDate(Date inDate) {
        this.inDate = inDate;
    }

    public String getOutDate() {
        return outDate;
    }

    public void setOutDate(String outDate) {
        this.outDate = outDate;
    }

    public AvailabilityStatus getStatus() {
        return status;
    }

    public void setStatus(AvailabilityStatus status) {
        this.status = status;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getRoomDescription() {
        return roomDescription;
    }

    public void setRoomDescription(String roomDescription) {
        this.roomDescription = roomDescription;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "bookingId=" + bookingId +
                ", clientName='" + clientName + '\'' +
                ", clientAddress='" + clientAddress + '\'' +
                ", clientMobileNumber='" + clientMobileNumber + '\'' +
                ", clientAadharNumber='" + clientAadharNumber + '\'' +
                ", clientId='" + clientId + '\'' +
                ", inDate=" + inDate +
                ", outDate='" + outDate + '\'' +
                ", status=" + status +
                ", roomNumber='" + roomNumber + '\'' +
                ", roomDescription='" + roomDescription + '\'' +
                '}';
    }
}
