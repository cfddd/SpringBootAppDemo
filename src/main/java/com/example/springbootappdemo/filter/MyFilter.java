package com.example.springbootappdemo.filter;

import com.alibaba.fastjson.JSONObject;
import com.example.springbootappdemo.entity.MyResult;
import com.example.springbootappdemo.utils.Jwt;
import com.sun.org.apache.bcel.internal.generic.GOTO;
import io.jsonwebtoken.Claims;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/*
1. 实现Filter
2. 配置 @WebFilter 和 @ServletComponentScan
 */
@Slf4j
@WebFilter(urlPatterns = "/*")   // 拦截路径
public class MyFilter implements Filter {

    private Claims claims;
    //过滤swagger的相关请求
    private static final Set<String> ALLOWED_PATHS = Collections.unmodifiableSet(new HashSet<>(
            Arrays.asList("/swagger-ui.html","/swagger-resources/configuration/ui",
                    "/swagger-resources/configuration/security","/swagger-resources", "/v2/api-docs", "/login")));
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        System.out.println("Filter Login in");
        // 调用接口前
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        String uri = req.getRequestURI().toString();
        log.info(uri);
        if(ALLOWED_PATHS.contains(uri)){
            filterChain.doFilter(servletRequest,servletResponse);
            return;
        }
        // 通过token拦截未登录
        String jwt = req.getHeader("token");
        if (jwt == null || jwt.length() == 0) {
            extracted(resp);
            return;
        }
        // 解析jwt
        try {
            claims = Jwt.ParseJwt(jwt);
        }catch (Exception e){
            e.printStackTrace();
            log.info("解析令牌" + jwt + "失败");
            extracted(resp);
            return;

        }
        // 调用接口
        filterChain.doFilter(servletRequest,servletResponse);

        // 调用接口后
    }

    private static void extracted(HttpServletResponse resp) throws IOException {
        MyResult result = MyResult.error(0,"NOT_LOGIN");
        String error = JSONObject.toJSONString(result);
        resp.getWriter().write(error);
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
