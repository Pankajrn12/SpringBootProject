package com.bus.busManagementSystem.resources;

import com.bus.busManagementSystem.models.SchedulModel;
import com.bus.busManagementSystem.services.SchedileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping("/abc")
public class ScheduleResource {
    @Autowired
    SchedileService schedileService;
    @Transactional
    @PostMapping("/saveSchedulDetails")
    public ResponseEntity saveSchedulDetails(@RequestBody SchedulModel schedulModel){
        return schedileService.saveSchedualDetails(schedulModel);
    }
    @PostMapping("/deleteSchedulById/{schedulId}")
    public ResponseEntity deleteSchedulById(@PathVariable ("schedulId") Long schedulId){
        return  schedileService.deleteSchedulById(schedulId);
    }
    @Transactional
    @PostMapping("/updateSchedulById")
    public ResponseEntity updateSchedulById(@RequestBody SchedulModel schedulModel){
        return schedileService.updateSchedulById(schedulModel);
    }

    @GetMapping("/getSchedulDetails")
    public List<SchedulModel> getSchedulDetails(){
        return schedileService.getSchedulDetails();
    }
}
