package com.trade.rest;

import com.trade.entities.Order;
import com.trade.services.OrderSearchCriteria;
import com.trade.services.OrderService;
import io.swagger.annotations.ApiOperation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import java.util.Map;

@RestController
@CrossOrigin()
@RequestMapping(value = "/api/orders", produces = MediaType.APPLICATION_JSON_VALUE)
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
    public ResponseEntity<Order> addOrder(@RequestBody Order order) {
        try {
            orderService.addNewOrder(order);
        } catch (Exception e) {
            logger.info(e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @DeleteMapping("/orderId")
    public ResponseEntity<Order> deleteById(@RequestParam int orderId){
        boolean found = orderService.deleteOrderById(orderId);
        if(found){
            return new ResponseEntity<>(HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/orderId")
    public ResponseEntity<Order> getById(@RequestParam int orderId) {
        Order order = orderService.getOrderById(orderId);
        if (order == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(order, HttpStatus.OK);
        }
    }

    @GetMapping("/SIN")
    public ResponseEntity<List<Order>> getOrdersBySIN(@RequestParam String SIN) {
        if (orderService.findBySIN(SIN).isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<List<Order>>(orderService.findBySIN(SIN), HttpStatus.OK);
        }
    }

    @GetMapping("/ticker")
    public ResponseEntity<List<Order>> getOrdersByTicker(@RequestParam String ticker) {
        if (orderService.findByTicker(ticker).isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<List<Order>>(orderService.findByTicker(ticker), HttpStatus.OK);
        }
    }


    @GetMapping("/custom")
    public ResponseEntity<List<Order>> getOrderByFilter(@RequestParam(required = false) Optional<Integer> orderId,
                                                        @RequestParam(required = false) Optional<String> SIN,
                                                        @RequestParam(required = false) Optional<String> ticker) {
        OrderSearchCriteria criteria = new OrderSearchCriteria(orderId, SIN, ticker);
        //System.out.println("orderId: " + orderId);
        //System.out.println("SIN: " + SIN);
        //System.out.println("ticker: " + ticker);
        List<Order> result = orderService.findByFilter(criteria);
        if (result.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<List<Order>>(result, HttpStatus.OK);
        }
    }
    @GetMapping("/Portfolio")
    public ResponseEntity<List<Map<String,Object>>> getPortfolioBySIN(@RequestParam String SIN){
        List<Map<String, Object>> result = orderService.findBySINGroupByTicker(SIN);
        if(result.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else{
            return new ResponseEntity<List<Map<String, Object>>>(result, HttpStatus.OK);
        }
    }
}
