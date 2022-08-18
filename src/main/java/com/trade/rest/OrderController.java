package com.trade.rest;

import com.trade.entities.Order;
import com.trade.services.OrderService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public Order getOrderById(@PathVariable("id") int id) {
        return orderService.getOrderById(id);
    }

    @RequestMapping(method=RequestMethod.GET, value="/404/{id}")
    public ResponseEntity<Order> getByIdWith404(@PathVariable("id") int id) {
        Order order = orderService.getOrderById(id);
        if (order == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else {
            return new ResponseEntity<>(order, HttpStatus.OK);
        }
    }

    @GetMapping("/SIN")
    public ResponseEntity<List<Order>> getOrdersBySIN(@RequestParam String SIN) {
        return new ResponseEntity<List<Order>>(orderService.findBySIN(SIN), HttpStatus.OK);
    }

    @GetMapping("/ticker")
    public ResponseEntity<List<Order>> getLaptopsByBrand(@RequestParam String ticker) {
        return new ResponseEntity<List<Order>>(orderService.findByTicker(ticker), HttpStatus.OK);
    }
}
