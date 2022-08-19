package com.trade.repos;

import com.trade.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {

    public List<Order> findBySIN(String SIN);

    public List<Order> findByTicker(String ticker);
}
