package com.studyall.study.proxy;

import java.util.Arrays;

public class Runner {
    public static void main(String[] args) {
        OrderService orderService = new OrderServiceImpl();
        LoggingProxy proxy = new LoggingProxy(orderService);

        User buyer = new User();
        buyer.setUsername("주문지");
        buyer.setUserId(1);
        buyer.setAddress("구로");

        Goods goods = new Goods();
        goods.setName("치킨");
        goods.setPrice(10000d);
        goods.setGoodsId(1);

        proxy.orderGoods(buyer, Arrays.asList(goods));


        OrderService orderServiceProxy = JDKRuntimeProxy.getOrderServiceProxy(new OrderServiceImpl());
        orderServiceProxy.orderGoods(buyer, Arrays.asList(goods));

        OrderService cglibOrderServiceProxy = CGLib.getOrderServiceProxy(new OrderServiceImpl());
        cglibOrderServiceProxy.orderGoods(buyer, Arrays.asList(goods));
    }
}
