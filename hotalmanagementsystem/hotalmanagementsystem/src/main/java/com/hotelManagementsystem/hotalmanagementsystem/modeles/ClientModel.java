package com.hotelManagementsystem.hotalmanagementsystem.modeles;

import java.util.Date;

public class ClientModel {
    private Long clientId;
    private String clientName;
    private String clientAddress;
    private String clientMobileNumber;
    private String clientAadharNumber;
    private Date creationDate;

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
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

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    @Override
    public String toString() {
        return "ClientModel{" +
                "clientId=" + clientId +
                ", clientName='" + clientName + '\'' +
                ", clientAddress='" + clientAddress + '\'' +
                ", clientMobileNumber='" + clientMobileNumber + '\'' +
                ", clientAadharNumber='" + clientAadharNumber + '\'' +
                ", creationDate=" + creationDate +
                '}';
    }
}
