package com.canteen.canteenManagementSystem.services;

import com.canteen.canteenManagementSystem.entities.Vender;
import com.canteen.canteenManagementSystem.models.VenderModel;
import com.canteen.canteenManagementSystem.repositories.VenderRepositry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

@Service
public class VenderService {
    @Autowired
    VenderRepositry venderRepositry;
    @Autowired
    EntityManager entityManager;

    public ResponseEntity saveVenderAllDetails(VenderModel venderModel) {
        Vender vender = new Vender();
        vender.setVenderName(venderModel.getVenderName());
        vender.setVenderEmail(venderModel.getVenderEmail());
        vender.setVenderPassword(venderModel.getVenderPassword());
        vender.setCanteenId(venderModel.getCanteenId());
        venderRepositry.save(vender);
        return new ResponseEntity<>("Saved Data", HttpStatus.OK);
    }

    public ResponseEntity updateVenderById(VenderModel venderModel) {
        entityManager.createNativeQuery("update vender set canteen_id =:canteen_id , vender_email =:vender_email , vender_name =:vender_name , vender_password =:vender_password where vender_id =:vender_id ")
                .setParameter("canteen_id",venderModel.getCanteenId())
                .setParameter("vender_email",venderModel.getVenderEmail())
                .setParameter("vender_name", venderModel.getVenderName())
                .setParameter("vender_password",venderModel.getVenderPassword())
                .setParameter("vender_id",venderModel.getVenderId()).executeUpdate();
        return new ResponseEntity<>("Data Updated", HttpStatus.OK);
    }

    public ResponseEntity deleteVenderById(Long venderId) {
        venderRepositry.deleteById(venderId);
        return new ResponseEntity<>("Data Deleted", HttpStatus.OK);
    }

    public List<VenderModel> getVenderDetails() {
        List<VenderModel> venderModelList = new ArrayList<>();
        List<Vender> venderList = venderRepositry.findAll();
        venderList.stream().forEach(data->{
            VenderModel model = new VenderModel();
            model.setVenderId(data.getVenderId());
            model.setVenderEmail(data.getVenderEmail());
            model.setVenderName(data.getVenderName());
            model.setVenderPassword(data.getVenderPassword());
            model.setCanteenId(data.getCanteenId());

            venderModelList.add(model);
        });
        return venderModelList;
    }
}
