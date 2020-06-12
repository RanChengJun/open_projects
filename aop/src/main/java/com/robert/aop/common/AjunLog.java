package com.robert.aop.common;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface AjunLog {
    String f1() default "码农的血与泪";

    String f2() default "我敲的不是代码而是键盘";
}
