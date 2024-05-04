package com.example.springbootappdemo.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Arrays;
/*
@Slf4j
@Component
@Aspect
public class JoinPoints {
    @Pointcut("execution(* com.example.springbootappdemo.service.*.*(..))")
    private void pc(){}
    @Around("pc()")   // 切入点表达式
    public Object recordTime(ProceedingJoinPoint joinPoint) throws Throwable {


        String className = joinPoint.getTarget().getClass().getName();
        log.info("className " + className);

        String methodName = joinPoint.getSignature().getName();
        log.info("methodName " + methodName);

        Object[] args = joinPoint.getArgs();
        log.info("形参 " + Arrays.toString(args));

        Object MyResult = joinPoint.proceed();
        log.info("returning" + MyResult.toString());

        return MyResult;
    }
    @Before("pc()")
    public void Before(JoinPoint joinPoint)
    {
        log.info("before ...");
    }
}
*/