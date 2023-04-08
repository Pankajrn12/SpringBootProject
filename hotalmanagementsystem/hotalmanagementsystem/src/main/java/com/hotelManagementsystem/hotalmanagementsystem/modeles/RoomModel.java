package com.hotelManagementsystem.hotalmanagementsystem.modeles;

import com.hotelManagementsystem.hotalmanagementsystem.status.AvailabilityStatus;

public class RoomModel {
    private Long roomId;
    private String flor;
    private String description;
    private String status;
    private String roomNumber;

    public Long getRoomId() {
        return roomId;
    }

    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }

    public String getFlor() {
        return flor;
    }

    public void setFlor(String flor) {
        this.flor = flor;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    @Override
    public String toString() {
        return "RoomModel{" +
                "roomId=" + roomId +
                ", flor='" + flor + '\'' +
                ", description='" + description + '\'' +
                ", status='" + status + '\'' +
                ", roomNumber='" + roomNumber + '\'' +
                '}';
    }
}
