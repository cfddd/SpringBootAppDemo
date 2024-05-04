package com.example.springbootappdemo.service.impl;

import com.example.springbootappdemo.entity.User;
import com.example.springbootappdemo.mapper.UserMapper;
import com.example.springbootappdemo.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Login implements LoginService {
    @Autowired
    UserMapper userMapper;
    private User find;

    @Override
    public User login(User user) {
        return userMapper.checkLogin(user);
    }
}
