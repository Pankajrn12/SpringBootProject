package com.canteen.canteenManagementSystem.resources;

import com.canteen.canteenManagementSystem.entities.OrderItem;
import com.canteen.canteenManagementSystem.models.OrderItemModel;
import com.canteen.canteenManagementSystem.services.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping("/abc")
public class OrderItemResource {
    @Autowired
    OrderItemService orderItemService;
    @Autowired
    EntityManager entityManager;

    @Transactional
    @PostMapping("/saveOrderItemAllDetails")
    public ResponseEntity saveOrderItemAllDetails(@RequestBody OrderItemModel orderItemModel){
        return  orderItemService.saveOrderItemAllDetails(orderItemModel);
    }
   @Transactional
    @PostMapping("updateOrderItemById")
    public ResponseEntity updateOrderItemById(@RequestBody OrderItemModel orderItemModel){
        return orderItemService.updateOrderItemById(orderItemModel);
   }
   @PostMapping("/deleteOrderItemById/{orderItemId}")
    public ResponseEntity deleteOrderItemById(@PathVariable ("orderItemId") Long orderItemId ){
        return orderItemService.deleteOrderItemById(orderItemId);
   }
   @GetMapping("/getOrderItemDetails")
    public List<OrderItemModel> getOrderItemDetails (){
        return orderItemService.getOrderItemDetails();
   }
}
