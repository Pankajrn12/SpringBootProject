package com.canteen.canteenManagementSystem.resources;

import com.canteen.canteenManagementSystem.models.VenderModel;
import com.canteen.canteenManagementSystem.services.VenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping("/abc")
public class VenderResource {
    @Autowired
    VenderService venderService;
    @Autowired
    EntityManager entityManager;

    @Transactional
    @PostMapping("/saveVenderAllDetails")
    public ResponseEntity saveVenderAllDetails(@RequestBody VenderModel venderModel){
        return  venderService.saveVenderAllDetails(venderModel);
    }
    @Transactional
    @PostMapping("/updateVenderById")
    public ResponseEntity updateVenderById(@RequestBody VenderModel venderModel){
        return venderService.updateVenderById(venderModel);
    }
    @PostMapping("/deleteVenderById/{venderId}")
    public ResponseEntity deleteVenderById (@PathVariable ("venderId") Long venderId){
        return venderService.deleteVenderById(venderId);
    }

    @GetMapping("/getVenderDetails")
    public List<VenderModel>getVenderDetails(){
        return venderService.getVenderDetails();
    }
}
