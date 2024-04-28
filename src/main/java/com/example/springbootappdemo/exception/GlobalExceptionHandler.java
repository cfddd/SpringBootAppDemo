package com.example.springbootappdemo.exception;


import org.apache.ibatis.annotations.Result;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;



@RestControllerAdvice
public class GlobalExceptionHandler {
//    @ExceptionHandler(Exception.class)
//    public Result ex(Exception ex){
//        ex.printStackTrace();
//        return Result.error("");
//    }
}
