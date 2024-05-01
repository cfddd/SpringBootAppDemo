package com.example.springbootappdemo.aop;
/*
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@Aspect
public class CutPoint {
    @Pointcut("execution(public String com.example.springbootappdemo.demos.Contorller.FileUploadController." +
            "upload(java.lang.String," +
            "org.springframework.web.multipart," +
            "javax.servlet.http)" +
            "throws java.io.IOException)")
    public void pc(){}

    // 使用了@MyLog注解的方法会自动执行下面的函数
    @Pointcut("@annotation(com.example.springbootappdemo.aop.MyLog)")
    public void pd(){}

    @Before("pd()")
    public void Before(){
        log.info("before ...");
    }
    @After("pd()")
    public void After(){
        log.info("After ...");
    }
}
*/