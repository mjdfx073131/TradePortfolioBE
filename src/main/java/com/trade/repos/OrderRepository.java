package com.trade.repos;

import com.trade.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {

    public List<Order> findBySIN(String SIN);

    public List<Order> findByTicker(String ticker);

    @Query(value="select ticker, sum(shares) as shares, avg(unitPrice) as avgPrice from orders where SIN=:SIN group by ticker", nativeQuery = true)
    public List<Map<String, Object>> findBySINGroupByTicker(String SIN);
}
