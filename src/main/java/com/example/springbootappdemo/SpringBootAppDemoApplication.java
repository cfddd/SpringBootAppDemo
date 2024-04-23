package com.example.springbootappdemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2  //加入EnableSwagger2
@SpringBootApplication
@MapperScan("com.example.springbootappdemo.mapper")// mapper包路径
public class SpringBootAppDemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootAppDemoApplication.class, args);
    }

}
