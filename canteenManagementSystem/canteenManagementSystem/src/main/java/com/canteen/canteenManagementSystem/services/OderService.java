package com.canteen.canteenManagementSystem.services;

import com.canteen.canteenManagementSystem.entities.Orders;
import com.canteen.canteenManagementSystem.models.OrderItemModel;
import com.canteen.canteenManagementSystem.models.OrderModel;
import com.canteen.canteenManagementSystem.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

@Service
public class OderService {
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    EntityManager entityManager;


    public ResponseEntity saveOrderAllDetails(OrderModel orderModel) {
        Orders order = new Orders();
        order.setVenderId(orderModel.getVenderId());
        order.setOrderStatus(orderModel.getOrderStatus());
        order.setCustomerId(orderModel.getCustomerId());
        order.setOrderTotalAmmount(orderModel.getOrderTotalAmmount());

        orderRepository.save(order);
        return new ResponseEntity<>("Seved data", HttpStatus.OK);

    }

    public ResponseEntity updateOrderById(OrderModel orderModel) {
        entityManager.createNativeQuery("update orders set customer_id =:customer_id , order_status =:order_status , order_total_ammount =:order_total_ammount , vender_id =:vender_id where order_id =:order_id ")
                .setParameter("customer_id", orderModel.getCustomerId())
                .setParameter("order_status", orderModel.getOrderStatus())
                .setParameter("order_total_ammount", orderModel.getOrderTotalAmmount())
                .setParameter("vender_id", orderModel.getVenderId())
                .setParameter("order_id", orderModel.getOrderId()).executeUpdate();
        return new ResponseEntity<>("Updated data", HttpStatus.OK);
    }

    public ResponseEntity deleteOrderById(Long orderId) {
        orderRepository.deleteById(orderId);
        return new ResponseEntity<>("Data deleted", HttpStatus.OK);
    }

    public List<OrderModel> getOrderDetails() {
        List<OrderModel>orderModelList = new ArrayList<>();
        List<Orders> ordersList = orderRepository.findAll();
        ordersList.stream().forEach(data->{
            OrderModel model = new OrderModel();
            model.setOrderId(data.getOrderId());
            model.setOrderStatus(data.getOrderStatus());
            model.setOrderTotalAmmount(data.getOrderTotalAmmount());
            model.setVenderId(data.getVenderId());
            model.setCustomerId(data.getCustomerId());

            orderModelList.add(model);
        });
        return orderModelList;
    }
}
