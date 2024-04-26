package com.example.springbootappdemo.service.impl;

import com.example.springbootappdemo.dao.EmpDao;
import com.example.springbootappdemo.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component // 将当前类交给IOC容器管理，成为IOC容器中的Bean，实现控制反转
// 如果有两个相同的实现，spring会报错阻止启动
public class GetDataInstead implements EmpService {
    @Autowired //运行时IOC容器会提供该类型的bean对象，并赋值给该对象，实现依赖注入
    private EmpDao empDao;

    @Override
    public List<String> getData() {
        return empDao.genData();
    }
}
