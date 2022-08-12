package com.trade.entities;

import javax.persistence.*;
import java.io.Serializable;


@Entity @Table(name="orders")
public class Order implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="orderId") private Integer orderId;
    @Column(name="SIN") private String SIN;
    @Column(name="ticker") private String ticker;
    @Column(name="shares") private Integer shares;
    @Column(name="unitPrice") private Double unitPrice;
    @Column(name="status_code") private Integer status_code;


    public Order() {}

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public String getSIN() {
        return SIN;
    }

    public void setSIN(String SIN) {
        this.SIN = SIN;
    }

    public String getTicker() {
        return ticker;
    }

    public void setTicker(String ticker) {
        this.ticker = ticker;
    }

    public Integer getShares() {
        return shares;
    }

    public void setShares(int shares) {
        this.shares = shares;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Integer getStatus_code() {
        return status_code;
    }

    public void setStatus_code(int status_code) {
        this.status_code = status_code;
    }

    public Order(Integer orderId, String SIN, String ticker, Integer shares, Double unitPrice, Integer status_code){
        this.orderId = orderId;
        this.SIN = SIN;
        this.ticker = ticker;
        this.shares = shares;
        this.unitPrice = unitPrice;
        this.status_code = status_code;
    }

}