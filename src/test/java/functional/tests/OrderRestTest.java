package functional.tests;

import com.trade.entities.Order;
import org.junit.jupiter.api.Test;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.greaterThan;

public class OrderRestTest {

    private RestTemplate template = new RestTemplate();

    @Test
    public void testFindAll() {
        List<Order> orders = template.getForObject("http://localhost:8080/api/orders", List.class);
        assertThat(orders.size(),  greaterThan(0));
    }

    @Test
    public void testOrderById() {
        Order order = template.getForObject
                ("http://localhost:8080/api/orders/orderId?orderId=4", Order.class);
        assertThat(order.getSIN(), equalTo("943999000"));
        assertThat(order.getTicker(), equalTo("COIN"));

    }

}
