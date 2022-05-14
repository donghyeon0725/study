package com.studyall.study.proxy;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class Order {
    private int orderId;
    private double price;
    private User buyer;
    private List<Goods> goods;
    private Date createdAt;
}
