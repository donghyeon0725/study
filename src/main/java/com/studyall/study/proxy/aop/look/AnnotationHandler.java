package com.studyall.study.proxy.aop.look;

public interface AnnotationHandler {
    void handle(ApplicationContext applicationContext);

    Class getAnnotationType();
}
