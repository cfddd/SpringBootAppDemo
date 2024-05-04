package com.example.springbootappdemo.Contorller;

import com.example.springbootappdemo.entity.User;
import org.springframework.web.bind.annotation.*;

@RestController
public class BasicRestController {
    // http://localhost:8080/hello1
    // http://localhost:8080/hello1?nickname=cfd&user_id=2
    @RequestMapping(value = "/hello1",method = RequestMethod.GET)
    public String hello1(String nickname,String user_id) {
        return "Hello " + nickname + " user_id " + user_id;
    }

    // http://localhost:8080/hello2?nickname=cfd
    @RequestMapping(value = "/hello2",method = RequestMethod.GET)
    public String hello2(@RequestParam("nickname") String name) {
        return "Hello " + name;
    }

    @RequestMapping(value = "/testPost1",method = RequestMethod.POST)
    public String hello3(String name) {
        return "Hello " + name;
    }
    // http://localhost:8080/testPost2
    @RequestMapping(value = "/testPost2",method = RequestMethod.POST)
    public String hello4(User user) {
        System.out.println(user.getName()+" "+user.getAge());
        return user.getName();
    }
    // http://localhost:8080/testPost3
    @RequestMapping(value = "/testPost3",method = RequestMethod.POST)
    public String hello5(@RequestBody User user) {
        System.out.println(user.getName()+" "+user.getAge());
        return user.getName();
    }
    // http://localhost:8080/all/**
    @RequestMapping(value = "/testPost3/**",method = RequestMethod.POST)
    public String all() {
        return "通配符";
    }
}
