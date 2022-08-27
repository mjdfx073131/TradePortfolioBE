package com.trade.controller;

import com.trade.entities.Order;
import com.trade.repos.OrderRepository;
import com.trade.rest.OrderController;
import com.trade.services.OrderService;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
public class TestOrderControllerUnitTest {
    @Autowired
    private OrderController controller;

//    @TestConfiguration
    protected static class Config {

        @Bean
        @Primary
        public OrderRepository repo() {
            return mock(OrderRepository.class);
        }

        @Bean
        @Primary
        public OrderService service() {
            Order order = new Order();
            List<Order> orders = new ArrayList<>();
            orders.add(order);

            OrderService service = mock(OrderService.class);
            when(service.getAllOrders()).thenReturn(orders);
            when(service.getOrderById(1)).thenReturn(order);
            return service;
        }

        @Bean
        @Primary
        public OrderController controller() {
            return new OrderController();
        }
    }

    @Disabled
    @Test
    public void testFindAll() {
        Iterable<Order> cds = controller.findAll();
        Stream<Order> stream = StreamSupport.stream(cds.spliterator(), false);
        assertThat(stream.count(), equalTo(1L));
    }

    @Disabled
    @Test
    public void testCdById() {
        ResponseEntity<Order> order = controller.getById(1);
        assertNotNull(order);
    }
}
