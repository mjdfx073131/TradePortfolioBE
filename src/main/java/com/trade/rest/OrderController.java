package com.trade.rest;

import com.trade.entities.Order;
import com.trade.services.OrderService;
import io.swagger.annotations.ApiOperation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/orders")
@CrossOrigin
public class OrderController {


    private static Logger logger = LogManager.getLogger(OrderController.class);

    @Autowired
    private OrderService orderService;
    @ApiOperation(value = "findAll", nickname = "findAll")
    @RequestMapping(method = RequestMethod.GET)
    public Iterable<Order> findAll() {
        return orderService.getAllOrders();
    }

    @RequestMapping(method = RequestMethod.POST)
    public void addOrder(@RequestBody Order order) {
        orderService.addNewOrder(order);
    }
}
