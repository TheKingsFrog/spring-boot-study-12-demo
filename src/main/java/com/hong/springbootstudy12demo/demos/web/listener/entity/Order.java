package com.hong.springbootstudy12demo.demos.web.listener.entity;

import com.sun.org.apache.xpath.internal.operations.Or;
import lombok.Data;

@Data
public class Order {

    private String orderName;

    public Order(String orderName) {
        this.orderName = orderName;
    }

}
