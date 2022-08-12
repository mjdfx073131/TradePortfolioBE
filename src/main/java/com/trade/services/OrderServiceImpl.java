package com.trade.services;

import com.trade.entities.Order;
import com.trade.repos.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepository dao;
    public List<Order> getAllOrders() {
        return dao.findAll();
    }
}
