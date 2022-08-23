package com.trade.entities;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Order.class)
public class Order_ {
    public static volatile SingularAttribute<Order, Integer> orderId;
    public static volatile SingularAttribute<Order, String> SIN;
    public static volatile SingularAttribute<Order, String> ticker;
    public static volatile SingularAttribute<Order, Integer> shares;
    public static volatile SingularAttribute<Order, Double> unitPrice;
    public static volatile SingularAttribute<Order, Integer> status_code;
}
