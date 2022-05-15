package com.studyall.study.proxy.aop.look;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.*;

public class ApplicationContainer {
    private String path;
    private ApplicationContext context;
    private BeanDefinitionFinder finder;
    private BeanProcessor processor;
    private AnnotationHandlerChain annotationHandlerChain;

    public void init(String[] args) {
        // 구현체 생성
        createInstance();

        // bean processing
        processor.process(finder, context);

        addAllAnnotationHandler();

        // annotation handling
        annotationHandlerChain.handle(context);
    }

    // 모든 어노테이션 핸들러 추가
    private void addAllAnnotationHandler() {
        AnnotationHandler aopHandler = new AspectHandler(new ProxyCreator());
        this.annotationHandlerChain.add(aopHandler);
        this.addAllCustomAnnotationHandler();
    }

    // 사용자 추가 어노테이션 핸들러 추가
    private void addAllCustomAnnotationHandler() {
        Set<Class> classes = this.finder.findAllClassesUsingClassLoader(this.path);

        Iterator<Class> iterator = classes.iterator();
        while (iterator.hasNext()) {
            Class clazz = iterator.next();

            if (clazz.isAnnotationPresent(CustomAnnotationHandler.class)
                && clazz.getSuperclass().equals(AnnotationHandler.class)) {
                annotationHandlerChain.add(AnnotationHandler.class.cast(instantiateClass(clazz)));
            }
        }
    }

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

    public ApplicationContext getContext() {
        return this.context;
    }

    private void createInstance() {
        this.path = "com.studyall.study.proxy.aop.client";
        Map contextMap = new HashMap();
        ApplicationContext context = new LookApplicationContext(contextMap);

        BeanDefinitionFinder finder = new DefaultBeanDefinitionFinder();
        BeanProcessor processor = new DefaultBeanProcessor(this.path);

        List<AnnotationHandler> annotationHandlerList = new ArrayList<>();
        AnnotationHandlerChain annotationHandlerChain = new AnnotationHandlerChain(annotationHandlerList);
//        AnnotationHandler handler = new AOPHandler();
//        annotationHandlerChain.add(handler);

        this.context = context;
        this.finder = finder;
        this.processor = processor;
        this.annotationHandlerChain = annotationHandlerChain;
    }
}
