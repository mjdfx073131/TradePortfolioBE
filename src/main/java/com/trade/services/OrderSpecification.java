package com.trade.services;

import com.trade.entities.Order;
import com.trade.entities.Order_;
import org.springframework.data.jpa.domain.Specification;

import java.util.Optional;

public final class OrderSpecification {
    public static Specification<Order> createOrderSpecifications(OrderSearchCriteria searchCriteria) {
        return orderIDEqualTo(searchCriteria.orderId).and(SINEqualTo(searchCriteria.SIN)).and(tickerEqualTo(searchCriteria.ticker));
    }


    public static Specification<Order> orderIDEqualTo(Optional<Integer> orderId) {
        return (root, query, builder) -> {
            return orderId.map(id -> builder.equal(root.get(Order_.orderId), String.valueOf(id))
            ).orElse(null);
        };
    }

    public static Specification<Order> SINEqualTo(Optional<String> SIN) {
        return (root, query, builder) -> {
            return SIN.map(sin -> builder.equal(root.get(Order_.SIN), String.valueOf(sin))
            ).orElse(null);
        };
    }

    public static Specification<Order> tickerEqualTo(Optional<String> ticker) {
        return (root, query, builder) -> {
            return ticker.map(tick -> builder.equal(root.get(Order_.ticker), String.valueOf(tick))
            ).orElse(null);
        };
    }

}
