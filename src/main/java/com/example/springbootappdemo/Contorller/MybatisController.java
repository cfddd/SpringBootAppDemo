package com.example.springbootappdemo.Contorller;

import com.example.springbootappdemo.anno.MyLog;
import com.example.springbootappdemo.entity.User;
import com.example.springbootappdemo.mapper.UserMapper;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
/*
@RestController
public class MybatisController {
    // 自动注入UserMapper
    @Autowired
    private UserMapper userMapper;
    @MyLog
    @GetMapping("/user_list")
    public List query(){
        return userMapper.list();
    }
    @MyLog
    @PostMapping("/user")
    public String save(User user){
        int i = userMapper.insert(user);
        System.out.println(user);
        return i > 0?"插入成功":"插入失败";
    }
    @MyLog
    @DeleteMapping("/user")
    public String delete(int id){
        int i = userMapper.delete(id);
        return i > 0?"删除成功":"删除失败";

    }
    @MyLog
    @PutMapping("/user")
    public String update(User user){
        int i = userMapper.update(user);
        return i>0?"修改成功":"修改失败";
    }
    @MyLog
    @GetMapping("/user")
    public User find(int id){
        return userMapper.find(id);
    }
}
*/