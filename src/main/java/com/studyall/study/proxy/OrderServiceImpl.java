package com.studyall.study.proxy;

import java.util.ArrayList;
import java.util.List;

public final class OrderServiceImpl implements OrderService {

    private List<Order> orderRepository = new ArrayList<>();

    @Override
    public void orderGoods(User buyer, List<Goods> goods) {
        Order order = new Order();
        order.setGoods(goods);
        order.setBuyer(buyer);

        orderRepository.add(order);
    }
}
