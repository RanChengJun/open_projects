package com.robert.aop.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
@Order(1)
public class ExecutionAspect {
    @Pointcut("execution(* com.robert.aop.controller.TestController.*(..))")
    public void ajunLog() {
    }


    @Before("ajunLog()")
    public void doBefore(JoinPoint joinPoint) throws Throwable {
        System.err.println("注解方法开始处理前");
    }

    @Around(value = "ajunLog()")
    public Object processAjunLog(ProceedingJoinPoint point) throws Throwable {
        System.out.println("\r\n调用序号为 【1】");
        System.err.println("被注解标注的方法：" + point.getSignature().getName());
        Object[] str = point.getArgs();
        System.err.println("该方法的参数：" + Arrays.asList(str));
        return point.proceed();
    }

    @After(value = "ajunLog()")
    public void doAfter() throws Throwable {
        System.err.println("方法结束后 》》》》》》》》》》》》 After");
    }

    @AfterReturning(returning = "ret", pointcut = "ajunLog()")
    public void doAfterReturning(Object ret) throws Throwable {
        System.err.println("方法正常结束后（无异常） 》》》》》》》》》》》》》 AfterReturning");
        System.err.println(ret);
    }

    @AfterThrowing(throwing = "ret", pointcut = "ajunLog()")
    public void doAfterThrowing(Object ret) {
        System.out.println("注解方法执行抛出异常");
        System.err.println("尽情发挥你的想象，对于错误日志的处理怎么开心怎么来    ｡:.ﾟヽ(｡◕‿◕｡)ﾉﾟ.:｡+ﾟ");
        System.err.println(ret);
    }
}
