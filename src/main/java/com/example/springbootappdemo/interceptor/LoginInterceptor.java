package com.example.springbootappdemo.interceptor;

import com.alibaba.fastjson.JSONObject;
import com.example.springbootappdemo.entity.MyResult;
import com.example.springbootappdemo.utils.Jwt;
import io.jsonwebtoken.Claims;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Slf4j
@Component
public class LoginInterceptor implements HandlerInterceptor {
    private Claims claims;
    //过滤swagger的相关请求
    private static final Set<String> ALLOWED_PATHS = Collections.unmodifiableSet(new HashSet<>(
            Arrays.asList("/swagger-ui.html","/swagger-resources/configuration/ui",
                    "/swagger-resources/configuration/security","/swagger-resources", "/v2/api-docs", "/login")));
    @Override   // return true 放行，否则不放行
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("Interceptor Login in");
        // 调用接口前
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        String uri = req.getRequestURI().toString();
        log.info(uri);
        if(ALLOWED_PATHS.contains(uri)){
            return true;
        }
        // 通过token拦截未登录
        String jwt = req.getHeader("token");
        if (jwt == null || jwt.length() == 0) {
            extracted(resp);
            return false;
        }
        // 解析jwt
        try {
            claims = Jwt.ParseJwt(jwt);
        }catch (Exception e){
            e.printStackTrace();
            log.info("解析令牌" + jwt + "失败");
            extracted(resp);
            return false;

        }
        return true;
    }
    private static void extracted(HttpServletResponse resp) throws IOException {
        MyResult result = MyResult.error(0,"NOT_LOGIN");
        String error = JSONObject.toJSONString(result);
        resp.getWriter().write(error);
    }
}
