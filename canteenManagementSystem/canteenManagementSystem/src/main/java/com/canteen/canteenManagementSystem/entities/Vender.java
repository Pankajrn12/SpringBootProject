package com.canteen.canteenManagementSystem.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Vender {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long venderId;
    private String venderName;
    private String venderEmail;
    private String venderPassword;
    private Long canteenId;

    public Long getVenderId() {
        return venderId;
    }

    public void setVenderId(Long venderId) {
        this.venderId = venderId;
    }

    public String getVenderName() {
        return venderName;
    }

    public void setVenderName(String venderName) {
        this.venderName = venderName;
    }

    public String getVenderEmail() {
        return venderEmail;
    }

    public void setVenderEmail(String venderEmail) {
        this.venderEmail = venderEmail;
    }

    public String getVenderPassword() {
        return venderPassword;
    }

    public void setVenderPassword(String venderPassword) {
        this.venderPassword = venderPassword;
    }

    public Long getCanteenId() {
        return canteenId;
    }

    public void setCanteenId(Long canteenId) {
        this.canteenId = canteenId;
    }
}
