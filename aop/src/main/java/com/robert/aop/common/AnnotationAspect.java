package com.robert.aop.common;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component //加入Spring容器
@Aspect //切面类
@Order(0)//有多个切面类时,根据order先后执行
public class AnnotationAspect {
    @Around("@annotation(ajunLog)")
    public Object processAjunLog(ProceedingJoinPoint point, AjunLog ajunLog) throws Throwable {
        System.out.println("\r\n调用序号为 【0】");
        System.err.println("你前面在注解上给的名字：" + ajunLog.f1());
        Object[] str = point.getArgs();
        System.err.println("该方法的参数：" + Arrays.asList(str));
        return point.proceed(); //调用目标方法
    }


}