package com.mdynightfire.statusmachine.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.stereotype.Component;
import org.aspectj.lang.annotation.*;

//@Aspect
//@Component
public class LogAspect {
    @Pointcut("execution(public * com.mdynightfire.statusmachine.controller.*.*(..))")
    public void LogAspect() {}

    @Before("LogAspect()")
    public void doBefore(JoinPoint joinPoint){
        System.out.println("doBefore");
        joinPoint.getArgs();
    }

    @After("LogAspect()")
    public void doAfter(JoinPoint joinPoint){
        System.out.println("doAfter");
    }

    @AfterReturning(value = "LogAspect()", returning = "returnObject")
    public void doAfterReturning(JoinPoint joinPoint, Object returnObject) {
        System.out.println("doAfterReturning");
    }

    @AfterThrowing("LogAspect()")
    public void doAfterThrowing(JoinPoint joinPoint) {
        System.out.println("doAfterThrowing");
    }

    @Around("LogAspect()")
    public Object doAround(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("doAround");
        return joinPoint.proceed();
    }

}