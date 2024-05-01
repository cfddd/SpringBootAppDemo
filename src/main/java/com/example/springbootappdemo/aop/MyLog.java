package com.example.springbootappdemo.aop;

import com.alibaba.fastjson.JSONObject;
import com.example.springbootappdemo.entity.Log;
import com.example.springbootappdemo.mapper.LogMapper;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import java.time.LocalDateTime;
import java.util.Arrays;

@Slf4j
@Component
@Aspect // 使用时加上@MyLog就可以
public class MyLog {
    @Autowired
    private LogMapper logMapper;
    @Around("@annotation(com.example.springbootappdemo.anno.MyLog)")
    public Object record(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

//        String jwt = request.getHeader("token");
//        Claims claims = JwtUtils.parseJWT(jwt);
//        Integer operatorId = (Integer) claims.get("id");
        Integer operatorId = (Integer) 1;
        LocalDateTime localDateTime = LocalDateTime.now();
        Long begin = System.currentTimeMillis();
        String className = proceedingJoinPoint.getTarget().getClass().getName();
        String methodName = proceedingJoinPoint.getSignature().getName();
        String args = Arrays.toString(proceedingJoinPoint.getArgs());

        Object result = proceedingJoinPoint.proceed();
        Long cost = System.currentTimeMillis() - begin;
        String returnValue = JSONObject.toJSONString(result);

        Log OPlog = new Log(
                null,
                operatorId,
                localDateTime,
                className,
                methodName,
                args,
                returnValue,
                cost);
        logMapper.create(OPlog);
        log.info("操作 ： " + OPlog);
        return result;
    }
}