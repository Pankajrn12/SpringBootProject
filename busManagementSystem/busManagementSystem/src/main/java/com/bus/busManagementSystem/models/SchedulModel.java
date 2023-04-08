package com.bus.busManagementSystem.models;

public class SchedulModel {
    private Long scheduleId;
    private Long busId;
    private Long driverId;
    private Long routId;

    public Long getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(Long scheduleId) {
        this.scheduleId = scheduleId;
    }

    public Long getBusId() {
        return busId;
    }

    public void setBusId(Long busId) {
        this.busId = busId;
    }

    public Long getDriverId() {
        return driverId;
    }

    public void setDriverId(Long driverId) {
        this.driverId = driverId;
    }

    public Long getRoutId() {
        return routId;
    }

    public void setRoutId(Long routId) {
        this.routId = routId;
    }
}
