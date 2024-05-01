package com.example.springbootappdemo.demos.Contorller;

import com.example.springbootappdemo.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
@Scope("prototype")
//@Lazy       // 直到第一次运行时才会初始化，然后放到IOC容器当中
@RestController
public class TestBeanController {
    TestBeanController(){
        System.out.println("Constructor run ...");
    }
    @GetMapping("/test_bean")
    public List<String> TestBean(){
        return new ArrayList<>(10);
    }
}
