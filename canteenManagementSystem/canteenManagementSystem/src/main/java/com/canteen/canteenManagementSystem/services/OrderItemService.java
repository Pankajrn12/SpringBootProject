package com.canteen.canteenManagementSystem.services;

import com.canteen.canteenManagementSystem.entities.OrderItem;
import com.canteen.canteenManagementSystem.models.OrderItemModel;
import com.canteen.canteenManagementSystem.repositories.OrderItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrderItemService {
    @Autowired
    OrderItemRepository orderItemRepository;
    @Autowired
    EntityManager entityManager;

    public ResponseEntity saveOrderItemAllDetails(OrderItemModel orderItemModel) {
        OrderItem orderItem = new OrderItem();
        orderItem.setOrderReId(orderItemModel.getOrderReId());
        orderItem.setMenuItemId(orderItemModel.getMenuItemId());
        orderItem.setOrderQuentity(orderItemModel.getOrderQuentity());
        orderItemRepository.save(orderItem);
        return new ResponseEntity<>("Saved Data ", HttpStatus.OK);
    }

    public ResponseEntity updateOrderItemById(OrderItemModel orderItemModel) {
        entityManager.createNativeQuery("update order_item set menu_item_id =:menu_item_id , order_quentity =:order_quentity , order_re_id =:order_re_id  where order_item_id =:order_item_id ")
                .setParameter("menu_item_id",orderItemModel.getOrderItemId())
                .setParameter("order_quentity",orderItemModel.getOrderQuentity())
                .setParameter("order_re_id",orderItemModel.getOrderReId())
                .setParameter("order_item_id", orderItemModel.getOrderItemId()).executeUpdate();
        return new ResponseEntity<>("Data Updated", HttpStatus.OK);
    }

    public ResponseEntity deleteOrderItemById(Long orderItemId) {
        orderItemRepository.deleteById(orderItemId);
        return  new ResponseEntity<>("Data Delete", HttpStatus.OK);
    }

    public List<OrderItemModel> getOrderItemDetails() {
        List<OrderItemModel> orderItemModelList = new ArrayList<>();
        List<OrderItem> orderItemList = orderItemRepository.findAll();
        orderItemList.stream().forEach(data->{
            OrderItemModel model = new OrderItemModel();
            model.setOrderItemId(data.getOrderItemId());
            model.setMenuItemId(data.getMenuItemId());
            model.setOrderQuentity(data.getOrderQuentity());
            model.setOrderReId(data.getOrderReId());
            orderItemModelList.add(model);
        });
        return  orderItemModelList;
    }
}
