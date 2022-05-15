package com.studyall.study.proxy.aop.look;

import java.lang.reflect.Method;

public interface AspectI {
    <T> T handle(Object o, Method method, Object[] args) throws Exception;
}
