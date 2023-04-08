package com.canteen.canteenManagementSystem.models;

public class OrderItemModel {
    private Long orderItemId;
    private Long orderReId;
    private  Long menuItemId;
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
