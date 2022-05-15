package com.studyall.study.proxy.aop.look;


import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Set;

public class DefaultBeanProcessor implements BeanProcessor {

    private String scanPath;

    public DefaultBeanProcessor(String scanPath) {
        this.scanPath = scanPath;
    }

    @Override
    public void process(BeanDefinitionFinder beanDefinitionFinder, ApplicationContext applicationContext) {
        Set<Class> classDefinitions = beanDefinitionFinder.findAllClassesUsingClassLoader(scanPath);

        classDefinitions.forEach(clazz -> {
            if (clazz.isAnnotationPresent(Service.class)) {
                applicationContext.setBean(clazz.getName(), instantiateClass(clazz));
            }
            if (clazz.isAnnotationPresent(Aspect.class)) {
                applicationContext.setBean(clazz.getName(), instantiateClass(clazz));
            }
        });
    }

    // 원래는 빈 정의로 부터 필요한 의존성을 모두 로드해서, 주입해주어야 하지만 가볍게 구현
    private Object instantiateClass(Class clazz) {
        try {
            Constructor constructor = clazz.getConstructor();
            Object o = constructor.newInstance();
            return o;
        } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }
}
