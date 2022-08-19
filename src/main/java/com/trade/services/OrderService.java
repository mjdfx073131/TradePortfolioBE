package com.trade.services;

import com.trade.entities.Order;

import java.util.List;

public interface OrderService {
    // get all
    List<Order> getAllOrders();
    
    boolean deleteOrderById(int id);

    Order getOrderById(Integer orderId);

    List<Order> findBySIN(String SIN);
    List<Order> findByTicker(String ticker);
}
