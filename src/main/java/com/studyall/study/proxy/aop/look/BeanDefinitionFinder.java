package com.studyall.study.proxy.aop.look;


import java.util.Set;

public interface BeanDefinitionFinder {
    Set<Class> findAllClassesUsingClassLoader(String packageName);
}
