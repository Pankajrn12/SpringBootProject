package com.bus.busManagementSystem.services;

import com.bus.busManagementSystem.entities.Route;
import com.bus.busManagementSystem.models.RoutModel;
import com.bus.busManagementSystem.repositories.RouteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

@Service
public class RouteService {
    @Autowired
    RouteRepository routeRepository;
    @Autowired
    EntityManager entityManager;
    public ResponseEntity saveRoutDetails(RoutModel routModel) {
        Route route = new Route();
        route.setDestination(routModel.getDestination());
        route.setDistance(routModel.getDistance());
        route.setSource(routModel.getSource());

        routeRepository.save(route);
        return  new ResponseEntity<>("Data Seved", HttpStatus.OK);
    }

    public ResponseEntity deleteRoutById(Long routId) {
        routeRepository.deleteById(routId);
        return new ResponseEntity<>("Data Deleted", HttpStatus.OK);
    }

    public ResponseEntity updatedRoutBYId(RoutModel routModel) {
        entityManager.createNativeQuery("update route set destination =:destination, distance =:distance, source =:source where rout_id=:rout_id ")
                .setParameter("destination",routModel.getDestination())
                .setParameter("distance",routModel.getDistance())
                .setParameter("source",routModel.getSource())
                .setParameter("rout_id",routModel.getRoutId()).executeUpdate();
        return new ResponseEntity<>("Data Updated",HttpStatus.OK);
    }

    public List<RoutModel> getRoutDetails() {
        List<RoutModel>routModelList = new ArrayList<>();
        List<Route> routeList = routeRepository.findAll();
        routeList.stream().forEach(data->{
            RoutModel model = new RoutModel();
            model.setDestination(data.getDestination());
            model.setDistance(data.getDistance());
            model.setRoutId(data.getRoutId());
            model.setSource(data.getSource());

            routModelList.add(model);
        });
        return routModelList;
    }
}
