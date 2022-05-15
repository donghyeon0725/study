package com.studyall.study.proxy;

import org.springframework.cglib.proxy.Callback;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CGLib {
    public static OrderServiceImpl getOrderServiceProxy(OrderServiceImpl target) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(OrderServiceImpl.class); // 타깃 클래스
        enhancer.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {

                long startTime = System.nanoTime();
                method.invoke(target, args);
                long endTime = System.nanoTime();
                System.out.println((endTime - startTime) + " nanoseconds");

                return null;
            }
        });     // Handler
        Object proxy = enhancer.create(); // Proxy 생성

        return (OrderServiceImpl)proxy;
    }
}
