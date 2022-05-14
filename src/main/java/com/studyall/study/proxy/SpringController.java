package com.studyall.study.proxy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class SpringController {
    @Autowired
    private OrderService orderService;

    @RequestMapping(value = "order", method = RequestMethod.POST)
    public void order(int userId, List<Integer> goodsId) {
        // ... find 한다
//        orderService.orderGoods(buyer, goods);
    }
}
