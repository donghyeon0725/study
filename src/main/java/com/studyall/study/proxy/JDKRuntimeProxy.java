package com.studyall.study.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JDKRuntimeProxy {
    public static OrderService getOrderServiceProxy(OrderService target) {
        // 프록시로 구현해야할 메소드가 여러개인 경우 귀찮기 때문에 메소드 앞뒤로 들어갈 로직이 같다면 사용할만한 방법
        return (OrderService) Proxy.newProxyInstance(target.getClass().getClassLoader(),
                new Class[]{OrderService.class}, new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

                        long startTime = System.nanoTime();
                        method.invoke(target, args);
                        long endTime = System.nanoTime();
                        System.out.println((endTime - startTime) + " nanoseconds");

                        return null;
                    }
                }
        );
    }
}
