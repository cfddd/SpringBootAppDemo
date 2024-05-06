package com.example.springbootappdemo.Contorller;

import com.example.springbootappdemo.entity.MyResult;
import com.example.springbootappdemo.entity.User;
import com.example.springbootappdemo.service.LoginService;
import com.example.springbootappdemo.utils.Jwt;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
public class LoginController {
    @Autowired
    LoginService loginService;
    private User result;

    @PostMapping("/login")
    public MyResult login(String account, String password){
        User user = new User(null,null,null,null,account,password,null);
        result = loginService.login(user);
        if (result != null){
            Map<String,Object> claims = new HashMap<>();
            claims.put("id",user.getId());
            claims.put("name",user.getName());
            claims.put("account",user.getAccount());

            String jwt = Jwt.GenJwt(claims);
            return MyResult.success("登陆成功",jwt);
        }

        return MyResult.error(0,"登陆失败");

    }
}
