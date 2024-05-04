package com.example.springbootappdemo.Contorller;

import com.example.springbootappdemo.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TestEmpController {
    @Qualifier("getData")
    @Autowired //运行时IOC容器会提供该类型的bean对象，并赋值给该对象，实现依赖注入
    private EmpService empService;
    @GetMapping("/test_emp")
    public List<String> TestEmp(){
        return empService.getData();
    }
}
