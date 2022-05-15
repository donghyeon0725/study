package com.studyall.study.proxy.aop.look;

import java.util.Iterator;
import java.util.List;

public class AnnotationHandlerChain {
    private List<AnnotationHandler> chains;

    public AnnotationHandlerChain(List<AnnotationHandler> chains) {
        this.chains = chains;
    }

    public void add(AnnotationHandler handler) {
        chains.add(handler);
    }

    public void remove(AnnotationHandler handler) {
        chains.remove(handler);
    }

    public void handle(ApplicationContext applicationContext) {
        Iterator<AnnotationHandler> iterator = chains.iterator();

        while (iterator.hasNext()) {
            AnnotationHandler handler = iterator.next();
            handler.handle(applicationContext);
        }
    }
}
