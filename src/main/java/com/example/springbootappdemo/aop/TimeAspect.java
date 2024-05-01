package com.example.springbootappdemo.aop;
/*
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@Aspect
@Order(1)
public class TimeAspect {
    @Pointcut("execution(* com.example.springbootappdemo.service.*.*(..))")
    private void pc(){}

    // 4.@Around决定那些方法使用下面的代理
    @Around("pc()")   // 切入点表达式
    public Object recordTime(ProceedingJoinPoint joinPoint) throws Throwable {
        // 1.记录开始时间
        long begin = System.currentTimeMillis();

        // 2.调用原始方法运行
        Object result = joinPoint.proceed();

        // 3.计算结束时间，计算耗时操作
        long end = System.currentTimeMillis();
        log.info(joinPoint.getSignature() + " used " + (end - begin) + " ms");

        return result;
    }
    @Before("pc()")
    public void Before(){
        log.info("before ...");
    }
    @After("pc()")
    public void After(){
        log.info("After ...");
    }
    // 正常运行返回后才会运行（抛出异常不会运行）
    @AfterReturning("pc()")
    public void AfterReturning(){
        log.info("AfterReturning ...");
    }
    @AfterThrowing("pc()")
    public void AfterThrowing(){
        log.info("exception aroused");
    }
}
*/