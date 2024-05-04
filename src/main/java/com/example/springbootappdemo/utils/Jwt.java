package com.example.springbootappdemo.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Jwt {
    public static final SignatureAlgorithm SA = SignatureAlgorithm.HS256;
    public static final byte[] sign = "cfdBest".getBytes();
    public static Long timeLimit = 3600L*1000;

    public static String GenJwt(Map<String,Object> claims){
        return Jwts.builder()
                .signWith(SA, sign)
                .setClaims(claims)
                .setExpiration(new Date(System.currentTimeMillis() + timeLimit))
                .compact();
    }
    public static Claims ParseJwt(String jwtToken){
        return Jwts.parser()
                .setSigningKey(sign)
                .parseClaimsJws(jwtToken)
                .getBody();

    }
}
