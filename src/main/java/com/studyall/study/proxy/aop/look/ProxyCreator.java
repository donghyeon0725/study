package com.studyall.study.proxy.aop.look;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;

public class ProxyCreator {
    public <T> T getProxy(T target, AspectI aspectI) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(target.getClass()); // 타깃 클래스
        enhancer.setCallback((MethodInterceptor) (o, method, args, methodProxy) -> {
            aspectI.handle(target, method, args);
            return null;
        });     // Handler
        Object proxy = enhancer.create(); // Proxy 생성

        return (T)proxy;
    }
}
