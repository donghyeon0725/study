package com.studyall.study.proxy.aop.look;

import java.util.Iterator;
import java.util.Map;

public class AspectHandler implements AnnotationHandler {

    private ProxyCreator proxyCreator;

    public AspectHandler(ProxyCreator proxyCreator) {
        this.proxyCreator = proxyCreator;
    }

    @Override
    public void handle(ApplicationContext applicationContext) {

        // aop 빈을 찾아서 service 빈에 넣어주기
        AspectI aspectI = findAspect(applicationContext);

        Object bean = findTargetBean(applicationContext, aspectI);

        Object proxy = proxyCreator.getProxy(bean, aspectI);

        applicationContext.setBean(bean.getClass().getName(), proxy);
    }

    private Object findTargetBean(ApplicationContext applicationContext, AspectI aspectI) {
        Aspect annotation = aspectI.getClass().getAnnotation(Aspect.class);
        Class type = annotation.type();
        return applicationContext.getBean(type.getName(), type);
    }

    private AspectI findAspect(ApplicationContext applicationContext) {
        Iterator<Map.Entry<String, Object>> iterator = applicationContext.iterator();

        while (iterator.hasNext()) {
            Map.Entry<String, Object> next = iterator.next();

            if (next.getValue().getClass().isAnnotationPresent(Aspect.class)
                    && (next.getValue() instanceof AspectI)) {
                return (AspectI) next.getValue();
            }
        }
        return null;
    }

    @Override
    public Class getAnnotationType() {
        return Aspect.class;
    }
}
