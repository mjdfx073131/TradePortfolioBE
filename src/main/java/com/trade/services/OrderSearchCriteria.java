package com.trade.services;

import java.util.Optional;

public class OrderSearchCriteria {
    public Optional<Integer> orderId;
    public Optional<String> SIN;
    public Optional<String> ticker;

    public OrderSearchCriteria(Optional<Integer> orderId, Optional<String> SIN, Optional<String> ticker) {
        this.orderId = orderId;
        this.SIN = SIN;
        this.ticker = ticker;
    }
}
