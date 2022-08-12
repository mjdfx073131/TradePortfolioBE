package com.trade.services;

import com.trade.entities.Order;
import com.trade.repos.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepository dao;

    @Transactional(propagation = Propagation.REQUIRED)
    public List<Order> getAllOrders() {
        System.out.println(dao.findAll().toString());
        return dao.findAll();
    }
}
