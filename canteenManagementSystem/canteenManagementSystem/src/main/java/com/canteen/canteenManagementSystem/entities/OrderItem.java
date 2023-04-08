package com.canteen.canteenManagementSystem.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)

    private Long orderItemId;
    private Long orderReId;
    private Long menuItemId;
    private Long orderQuentity;

    public Long getOrderItemId() {
        return orderItemId;
    }

    public void setOrderItemId(Long orderItemId) {
        this.orderItemId = orderItemId;
    }

    public Long getOrderReId() {
        return orderReId;
    }

    public void setOrderReId(Long orderReId) {
        this.orderReId = orderReId;
    }

    public Long getMenuItemId() {
        return menuItemId;
    }

    public void setMenuItemId(Long menuItemId) {
        this.menuItemId = menuItemId;
    }

    public Long getOrderQuentity() {
        return orderQuentity;
    }

    public void setOrderQuentity(Long orderQuentity) {
        this.orderQuentity = orderQuentity;
    }
}
