package com.studyall.study.proxy.aop.look;

import java.util.Iterator;
import java.util.Map;

public class LookApplicationContext implements ApplicationContext {

    private Map<String, Object> map;

    public LookApplicationContext(Map<String, Object> map) {
        this.map = map;
    }

    @Override
    public synchronized <T> T getBean(String name, Class<T> clazz) {
        Object o = map.get(name);
        return clazz.cast(o);
    }

    @Override
    public void setBean(String name, Object object) {
        map.put(name, object);
    }

    @Override
    public Iterator iterator() {
        return map.entrySet().iterator();
    }
}
