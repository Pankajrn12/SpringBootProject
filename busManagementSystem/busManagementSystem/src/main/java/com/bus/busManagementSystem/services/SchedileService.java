package com.bus.busManagementSystem.services;

import com.bus.busManagementSystem.entities.Schedule;
import com.bus.busManagementSystem.models.SchedulModel;
import com.bus.busManagementSystem.repositories.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

@Service
public class SchedileService {
    @Autowired
    ScheduleRepository scheduleRepository;
    @Autowired
    EntityManager entityManager;
    public ResponseEntity saveSchedualDetails(SchedulModel schedulModel) {
        Schedule schedule = new Schedule();
        schedule.setScheduleId(schedulModel.getScheduleId());
        schedule.setBusId(schedulModel.getBusId());
        schedule.setRoutId(schedulModel.getRoutId());
        schedule.setDriverId(schedulModel.getDriverId());

        scheduleRepository.save(schedule);
        return new ResponseEntity<>("Data Seced", HttpStatus.OK);
    }

    public ResponseEntity deleteSchedulById(Long schedulId) {
        scheduleRepository.deleteById(schedulId);
        return new ResponseEntity<>("Data Deleted", HttpStatus.OK);
    }

    public ResponseEntity updateSchedulById(SchedulModel schedulModel) {
        entityManager.createNativeQuery("update schedule set bus_id =:bus_id, driver_id =:driver_id, rout_id =:rout_id where schedule_id =:schedule_id ")
                .setParameter("bus_id",schedulModel.getBusId())
                .setParameter("driver_id",schedulModel.getDriverId())
                .setParameter("rout_id",schedulModel.getRoutId())
                .setParameter("schedule_id",schedulModel.getScheduleId()).executeUpdate();
        return new ResponseEntity<>("Data Updated",HttpStatus.OK);
    }

    public List<SchedulModel> getSchedulDetails() {
        List<SchedulModel>schedulModelList = new ArrayList<>();
        List<Schedule> scheduleList = scheduleRepository.findAll();
        scheduleList.stream().forEach(data->{
            SchedulModel model = new SchedulModel();
            model.setBusId(data.getBusId());
            model.setScheduleId(data.getScheduleId());
            model.setDriverId(data.getDriverId());
            model.setRoutId(data.getRoutId());

            schedulModelList.add(model);
        });
        return schedulModelList;
    }
}
