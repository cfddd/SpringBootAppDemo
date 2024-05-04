package com.example.springbootappdemo.testJwt;

import com.example.springbootappdemo.utils.Jwt;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

//@SpringBootTest // 加上这个会运行整个spring项目再运行这里的Test，可以注释掉
public class testJwt {

    private String jwtToken;
    private Claims body;

    @Test
    public void testGen(){
        Map<String,Object> claims = new HashMap<>();
        claims.put("id",1);
        claims.put("name","cfd");

        System.out.println(Jwt.GenJwt(claims));
        // eyJhbGciOiJIUzI1NiJ9.eyJuYW1lIjoiY2ZkIiwiaWQiOjEsImV4cCI6MTcxNDgyNzc4NX0.QC0R9YoQa0Dzd2pE35nPbQWcVkeSiWyKXfP-dWiphwQ
    }

    @Test
    public void testParse(){
        Map<String,Object> claims = new HashMap<>();
        claims.put("id",1);
        claims.put("name","cfd");
        System.out.println(Jwt.ParseJwt(Jwt.GenJwt(claims)));
    }
}
