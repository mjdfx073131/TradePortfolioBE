package com.trade.services;

import com.trade.entities.Order;
import com.trade.repos.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepository dao;

    @Transactional(propagation = Propagation.REQUIRED)
    public List<Order> getAllOrders() {
        return dao.findAll();
    }

    @Override
    public boolean deleteOrderById(int id){
        Order order = dao.findById(id).orElse(null);
        if(order == null){
            return false;
        }else{
            dao.delete(order);
            return true;
        }
    }

    public Order getOrderById(Integer orderId){
        Optional<Order> orderOptional =  dao.findById(orderId);
        if (orderOptional.isPresent()) {
            return orderOptional.get();
        }
        else return null;
    }

    @Override
    public List<Order> findBySIN(String SIN){
        return (List<Order>) dao.findBySIN(SIN);
    };
    @Override
    public List<Order> findByTicker(String ticker){
        return (List<Order>) dao.findByTicker(ticker);
    };

}
