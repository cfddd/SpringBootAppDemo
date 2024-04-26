package com.example.springbootappdemo.dao.impl;

import com.example.springbootappdemo.dao.EmpDao;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository(value = "genData") // 将当前类交给IOC容器管理，成为IOC容器中的Bean，实现控制反转
public class GenData implements EmpDao {
    @Override
    public List<String> genData() {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            res.add((new Integer(i).toString()));
        }
        return res;
    }
}
