package com.hong.springbootstudy12demo.demos.web.event;

import com.hong.springbootstudy12demo.demos.web.listener.entity.Order;
import com.sun.org.apache.xpath.internal.operations.Or;
import lombok.Data;

@Data
public class OrderEvent {

    private Order order;

    private String addOrUpdate;

    public OrderEvent(Order order, String addOrUpdate) {
        this.order = order;
        this.addOrUpdate = addOrUpdate;
    }

}
