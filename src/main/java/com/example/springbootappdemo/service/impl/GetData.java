package com.example.springbootappdemo.service.impl;

import com.example.springbootappdemo.dao.EmpDao;
import com.example.springbootappdemo.dao.impl.GenData;
import com.example.springbootappdemo.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
@Primary
@Service // 将当前类交给IOC容器管理，成为IOC容器中的Bean，实现控制反转
public class GetData implements EmpService {
    @Autowired //运行时IOC容器会提供该类型的bean对象，并赋值给该对象，实现依赖注入
    private EmpDao empDao;

    @Override
    public List<String> getData() {
        return empDao.genData();
    }
}
