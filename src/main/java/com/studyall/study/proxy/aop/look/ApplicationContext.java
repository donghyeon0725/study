package com.studyall.study.proxy.aop.look;

import java.util.Iterator;
import java.util.Map;

public interface ApplicationContext {

    <T> T getBean(String name, Class<T> clazz);

    void setBean(String name, Object object);

    Iterator<Map.Entry<String, Object>> iterator();
}
