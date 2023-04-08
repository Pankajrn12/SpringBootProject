package com.canteen.canteenManagementSystem.resources;

import com.canteen.canteenManagementSystem.models.CanteenModel;
import com.canteen.canteenManagementSystem.services.CanteenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping("/abc")
public class CanteenResource {
    @Autowired
    CanteenService canteenService;
    @Autowired
    EntityManager entityManager;

    @Transactional
    @PostMapping("/saveCanteenAllDetails")
    public ResponseEntity saveCanteenAllDetails (@RequestBody CanteenModel canteenModel){
        return canteenService.saveCanteenAllDetails(canteenModel);
    }

    @Transactional
    @PostMapping("/updateCanteenDetails")
    public  ResponseEntity updateCanteenDetails(@RequestBody CanteenModel canteenModel){
        return canteenService.updateCanteenDetails(canteenModel);
    }
    @PostMapping("/deleteCanteenById/{canteenId}")
    public ResponseEntity deleteCanteenById (@PathVariable ("canteenId") Long canteenId){
        return canteenService.deleteCanteenById(canteenId);
    }

    @GetMapping("/getCanteenDetails")
    public List<CanteenModel> getCanteenDetails(){
        return canteenService.getCanteenDetails();
    }

}
