package com.studyall.study.proxy.aop.client;

import com.studyall.study.proxy.aop.look.Aspect;
import com.studyall.study.proxy.aop.look.AspectI;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@Aspect(type = MemberServiceImpl.class)
public class CustomAOPClass implements AspectI {

    @Override
    public <T> T handle(Object o, Method method, Object[] args) throws Exception {

        long startTime = System.nanoTime();
        try {
            method.invoke(o, args);
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        long endTime = System.nanoTime();
        System.out.println((endTime - startTime) + " nanoseconds");
        return null;
    }
}
