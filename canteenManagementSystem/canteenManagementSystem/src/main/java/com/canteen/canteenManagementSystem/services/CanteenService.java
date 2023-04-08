package com.canteen.canteenManagementSystem.services;

import com.canteen.canteenManagementSystem.entities.Canteen;
import com.canteen.canteenManagementSystem.models.CanteenModel;
import com.canteen.canteenManagementSystem.repositories.CanteenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

@Service
public class CanteenService {
    @Autowired
    CanteenRepository canteenRepository;
    @Autowired
    EntityManager entityManager;

    public ResponseEntity saveCanteenAllDetails(CanteenModel canteenModel) {
        Canteen canteen = new Canteen();
        canteen.setCanteenName(canteenModel.getCanteenName());
        canteen.setCanteenAddress(canteenModel.getCanteenAddress());
        canteen.setCanteenEmailId(canteenModel.getCanteenEmailId());
        canteen.setCanteenContactNumber(canteenModel.getCanteenContactNumber());

        canteenRepository.save(canteen);
        return new ResponseEntity<>("save Data", HttpStatus.OK);
    }

    public ResponseEntity updateCanteenDetails(CanteenModel canteenModel) {
            entityManager.createNativeQuery("update canteen set canteen_address =:canteen_address , canteen_contact_number =:canteen_contact_number , canteen_email_id =:canteen_email_id , canteen_name =:canteen_name where canteen_id =:canteen_id ")
                .setParameter("canteen_address",canteenModel.getCanteenAddress())
                .setParameter("canteen_contact_number",canteenModel.getCanteenContactNumber())
                .setParameter("canteen_email_id", canteenModel.getCanteenEmailId())
                    .setParameter("canteen_name", canteenModel.getCanteenName())
                    .setParameter("canteen_id",canteenModel.getCanteenId()).executeUpdate();

            return  new ResponseEntity<>("Data Updated",HttpStatus.OK);
    }


    public ResponseEntity deleteCanteenById(Long canteenId) {
        canteenRepository.deleteById(canteenId);
        return new ResponseEntity<>("Data Deleted", HttpStatus.OK);
    }

    public List<CanteenModel> getCanteenDetails() {
        List<CanteenModel> canteenModelList = new ArrayList<>();
        List<Canteen> canteenList = canteenRepository.findAll();
        canteenList.stream().forEach(data->{
            CanteenModel canteenModel = new CanteenModel();
            canteenModel.setCanteenId(data.getCanteenId());
            canteenModel.setCanteenName(data.getCanteenName());
            canteenModel.setCanteenEmailId(data.getCanteenEmailId());
            canteenModel.setCanteenContactNumber(data.getCanteenContactNumber());
            canteenModel.setCanteenAddress(data.getCanteenAddress());
            canteenModelList.add(canteenModel);
        });
        return canteenModelList;

    }
}
