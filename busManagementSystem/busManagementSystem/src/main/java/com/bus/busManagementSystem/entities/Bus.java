package com.bus.busManagementSystem.entities;

import javax.persistence.*;

@Entity
public class Bus {
    @Id
    @GeneratedValue (strategy = GenerationType.SEQUENCE)
    private Long busId;
    private  String name;
    private Integer seats;
    @OneToOne()
    @JoinColumn(name = "bus_id")
    private Route route;

    public Long getBusId() {
        return busId;
    }

    public void setBusId(Long busId) {
        this.busId = busId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSeats() {
        return seats;
    }

    public void setSeats(Integer seats) {
        this.seats = seats;
    }
}
