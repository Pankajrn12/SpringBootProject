package com.hotelManagementsystem.hotalmanagementsystem.entities;

import com.hotelManagementsystem.hotalmanagementsystem.status.AvailabilityStatus;

import javax.persistence.*;

@Entity
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long roomId;
    private String flor;
    private String description;
    private String roomNumber;
    @Enumerated(EnumType.STRING)
    private AvailabilityStatus status;

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

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public AvailabilityStatus getStatus() {
        return status;
    }

    public void setStatus(AvailabilityStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Room{" +
                "roomId=" + roomId +
                ", flor='" + flor + '\'' +
                ", description='" + description + '\'' +
                ", roomNumber='" + roomNumber + '\'' +
                ", status=" + status +
                '}';
    }
}
