package com.trade.repos;

import com.trade.entities.Order;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> , JpaSpecificationExecutor<Order> {

    public List<Order> findBySIN(String SIN);

    public List<Order> findByTicker(String ticker);


    public List<Order> findAll(@Nullable Specification<Order> spec);
}
