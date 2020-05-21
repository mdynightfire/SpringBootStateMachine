package com.aopexample.demo.aspect;

import javax.annotation.PostConstruct;

import com.aopexample.demo.annotation.DoneTime;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class DoneTimeAspect {

    @PostConstruct
    public void init(){
        System.out.println("init");
    }

    @Around("@annotation(doneTime)")
    public Object around(ProceedingJoinPoint joinPoint, DoneTime doneTime) throws Throwable {
        System.out.println("around");
        Object o = joinPoint.proceed();
        return o;
    }

    @After("@annotation(doneTime)")
    public void doAfter(JoinPoint joinPoint, DoneTime doneTime) {
        System.out.println("doAfter");
    }

    @Before("@annotation(doneTime)")
    public void doBefore(JoinPoint joinPoint, DoneTime doneTime) {
        System.out.println("doBefore");
    }

    @AfterThrowing("@annotation(doneTime)")
    public void doAfterThrowing(JoinPoint joinPoint, DoneTime doneTime) {
        System.out.println("doAfterThrowing");
    }
}
