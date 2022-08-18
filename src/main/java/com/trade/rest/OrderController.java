package com.trade.rest;

import com.trade.entities.Order;
import com.trade.services.OrderService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/orders")
@CrossOrigin
public class OrderController {

    @Autowired
    private OrderService orderService;
    @ApiOperation(value = "findAll", nickname = "findAll")
    @RequestMapping(method = RequestMethod.GET)
    public Iterable<Order> findAll() {
        return orderService.getAllOrders();
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public ResponseEntity<Order> deleteById(@PathVariable("id") int id){
        boolean found = orderService.deleteOrderById(id);
        if(found){
            return new ResponseEntity<>(HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
