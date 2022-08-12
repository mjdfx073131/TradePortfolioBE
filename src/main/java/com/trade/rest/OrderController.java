package com.trade.rest;

import com.trade.entities.Order;
import com.trade.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/orders")
@CrossOrigin
public class OrderController {

    @Autowired
    private OrderService orderService;

    @RequestMapping(method = RequestMethod.GET)
    public Iterable<Order> findAll() {
        return orderService.getAllOrders();
    }
}
