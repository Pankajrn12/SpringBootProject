package com.canteen.canteenManagementSystem.models;

public class OrderModel {
    private Long orderId;
    private Long customerId;
    private Long venderId;
    private String orderStatus;
    private Double orderTotalAmmount;

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Long getVenderId() {
        return venderId;
    }

    public void setVenderId(Long venderId) {
        this.venderId = venderId;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Double getOrderTotalAmmount() {
        return orderTotalAmmount;
    }

    public void setOrderTotalAmmount(Double orderTotalAmmount) {
        this.orderTotalAmmount = orderTotalAmmount;
    }
}
