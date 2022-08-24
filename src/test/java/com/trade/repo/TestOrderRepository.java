package com.trade.repo;

import com.trade.entities.Order;
import com.trade.repos.OrderRepository;
import com.trade.rest.OrderController;
import com.trade.services.OrderService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.hamcrest.MatcherAssert.assertThat;

@ExtendWith(SpringExtension.class)
@DataJpaTest // use an in memory database
@ContextConfiguration(classes=com.trade.AppConfig.class)
@TestPropertySource(locations = "classpath:application-test.properties") // this is only needed because swagger breaks tests
public class TestOrderRepository {

    @Autowired
    private TestEntityManager manager;


    @Autowired // this is a mock which is injected because of the @DataJpaTest
    private OrderRepository repo;

    @Autowired
    OrderService orderService;


    @Autowired
    OrderController controller;

    private int orderId;

    @BeforeEach
    public  void setupDatabaseEntryForReadOnlyTests() {
        Order order = new Order(null, "943111111","COIN",100,50.15,0);
        Order result = manager.persist(order);
//        manager.evict();
        orderId = result.getOrderId();
        System.out.println(orderId);


    }

    @Test
    public void canRetrieveOrderBySIN() {
        List<Order> orders = repo.findBySIN("943111111");
//      Stream<Order> stream = StreamSupport.stream(orders.spliterator(), false);
        assertTrue(orders.size()==1);

    }

    @Test
    public void orderServiceCanReturnAllOrders() {
        Iterable<Order> discs = orderService.getAllOrders();
        Stream<Order> stream = StreamSupport.stream(discs.spliterator(), false);
        Optional<Order> order = stream.findFirst();
        assertThat(order.get().getSIN(), equalTo("943111111"));
    }

    @Test
    public void controllerCanReturnOrderById() {
        ResponseEntity<Order> order = controller.getById(orderId);
        assertThat(order.getBody().getSIN(), equalTo("943111111"));
    }
}
