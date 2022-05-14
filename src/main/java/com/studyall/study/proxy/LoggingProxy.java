package com.studyall.study.proxy;

import java.util.List;

public class LoggingProxy implements OrderService {

    private OrderService orderService;

    public LoggingProxy(OrderService orderService) {
        this.orderService = orderService;
    }

    @Override
    public void orderGoods(User buyer, List<Goods> goods) {
        long startTime = System.nanoTime();
        orderService.orderGoods(buyer, goods);
        long endTime = System.nanoTime();
        System.out.println((endTime - startTime) + " nanoseconds");
    }
}
