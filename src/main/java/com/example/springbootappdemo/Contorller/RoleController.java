package com.example.springbootappdemo.Contorller;

import com.example.springbootappdemo.entity.Role;
import com.example.springbootappdemo.entity.User;
import com.example.springbootappdemo.mapper.RoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RoleController {
    @Autowired
    RoleMapper roleMapper;
    @GetMapping("/role")
    public Role getRoleById(Long id){
        return roleMapper.find(id);
    }
    @PostMapping("/role")
    public Integer create(Role role){
        return roleMapper.create(role);
    }
}
