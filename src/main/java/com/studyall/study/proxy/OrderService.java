package com.studyall.study.proxy;

import java.util.List;

public interface OrderService {
    void orderGoods(User buyer, List<Goods> goods);
}
