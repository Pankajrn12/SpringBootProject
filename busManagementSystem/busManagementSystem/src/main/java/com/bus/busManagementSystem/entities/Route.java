package com.bus.busManagementSystem.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Route {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long routId;
    private String source;
    private String destination;
    private Integer distance;

    public Long getRoutId() {
        return routId;
    }

    public void setRoutId(Long routId) {
        this.routId = routId;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Integer getDistance() {
        return distance;
    }

    public void setDistance(Integer distance) {
        this.distance = distance;
    }
}
