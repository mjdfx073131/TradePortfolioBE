package com.trade.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity @Table(name="orders")

//@NamedQueries(
//        {
//                @NamedQuery(name="order.getAll",
//                        query="select cd from CompactDisc as cd where cd.price > :price",
//                        hints = {@QueryHint(name = "org.hibernate.cacheable", value = "true")})
//        })

public class Order implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    // add attributes for all the remaining properties
    @Column(name="orderId") private int orderId;
    @Column(name="SIN") private String SIN;
    @Column(name="ticker") private String ticker;
    @Column(name="shares") private int shares;
    @Column(name="unitPrice") private double unitPrice;
    @Column(name="status_code") private int status_code;


    public Order() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
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

    public int getShares() {
        return shares;
    }

    public void setShares(int shares) {
        this.shares = shares;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getStatus_code() {
        return status_code;
    }

    public void setStatus_code(int status_code) {
        this.status_code = status_code;
    }

    public Order(int orderId, String SIN, String ticker, int shares, double unitPirce, int status_code){
        this.orderId = orderId;
        this.SIN = SIN;
        this.ticker = ticker;
        this.shares = shares;
        this.unitPrice = unitPirce;
        this.status_code = status_code;
    }

}