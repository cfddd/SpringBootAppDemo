package com.example.springbootappdemo.Contorller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.springbootappdemo.entity.User;
import com.example.springbootappdemo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    // 自动注入UserMapper
    @Autowired
    private UserMapper userMapper;
    @PostMapping("/user")
    public Integer createUser(User user){
        return userMapper.create(user);
    }
    @GetMapping("/user_list")
    public IPage list(int page,int size,String name){
        Page<User> config = new Page<>(page,size);
        QueryWrapper<User> queueWarpper = new QueryWrapper<>();
        if (name != null && !name.equals("")) {
            queueWarpper.like("name",name);
        }
        IPage iPage = userMapper.selectPage(config,queueWarpper);
        return iPage;
    }
    @GetMapping("/user")
    public User getUserById(Long id){
        return userMapper.find(id);
    }
}
