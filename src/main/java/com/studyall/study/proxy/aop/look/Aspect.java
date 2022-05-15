package com.studyall.study.proxy.aop.look;


import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Aspect {
    Class type();
}
