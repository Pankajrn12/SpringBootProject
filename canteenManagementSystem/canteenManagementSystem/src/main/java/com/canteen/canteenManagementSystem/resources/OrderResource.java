package com.canteen.canteenManagementSystem.resources;

import com.canteen.canteenManagementSystem.models.OrderModel;
import com.canteen.canteenManagementSystem.services.OderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping("/abc")
public class OrderResource {
    @Autowired
    OderService oderService;
    @Autowired
    EntityManager entityManager;

    @Transactional
    @PostMapping("/saveOrderAllDetails")
    public ResponseEntity saveOrderAllDetails(@RequestBody OrderModel orderModel){
        return oderService.saveOrderAllDetails(orderModel);
    }
    @Transactional
    @PostMapping("/updateOrderById")
    public ResponseEntity updateOrderById (@RequestBody OrderModel orderModel){
        return oderService.updateOrderById(orderModel);
    }
    @PostMapping("/deleteOrderById/{orderId}")
    public ResponseEntity deleteOrderById(@PathVariable ("orderId") Long orderId){
        return oderService.deleteOrderById(orderId);
    }

    @GetMapping("/getOrderDetails")
    public List<OrderModel> getOrderDetails(){
        return oderService.getOrderDetails();
    }

}
