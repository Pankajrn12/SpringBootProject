package com.canteen.canteenManagementSystem.models;

public class MenuModel {
    private Long menuId;
    private String menuName;
    private String menuDcription;
    private Double menuPrice;
    private Long venderId;

    public Long getMenuId() {
        return menuId;
    }

    public void setMenuId(Long menuId) {
        this.menuId = menuId;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getMenuDcription() {
        return menuDcription;
    }

    public void setMenuDcription(String menuDcription) {
        this.menuDcription = menuDcription;
    }

    public Double getMenuPrice() {
        return menuPrice;
    }

    public void setMenuPrice(Double menuPrice) {
        this.menuPrice = menuPrice;
    }

    public Long getVenderId() {
        return venderId;
    }

    public void setVenderId(Long venderId) {
        this.venderId = venderId;
    }
}
