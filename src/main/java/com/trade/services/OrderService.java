package com.trade.services;

import com.trade.entities.Order;

import java.util.List;
import java.util.Map;

public interface OrderService {
    // get all
    List<Order> getAllOrders();

    Order addNewOrder(Order order);
    
    boolean deleteOrderById(int id);


    Order getOrderById(Integer orderId);

    List<Order> findBySIN(String SIN);
    List<Order> findByTicker(String ticker);

    List<Order> findByFilter(OrderSearchCriteria searchCriteria);

    List<Map<String,Object>> findBySINGroupByTicker(String SIN);

}
