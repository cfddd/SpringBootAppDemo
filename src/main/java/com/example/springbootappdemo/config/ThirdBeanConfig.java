package com.example.springbootappdemo.config;

import com.example.springbootappdemo.service.impl.GetData;
import org.dom4j.io.SAXReader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ThirdBeanConfig {
    // 声明第三方Bean
    @Bean   // 将当前方法的返回值对象交给IOC容器管理，成为IOC容器bean
            // 通过@Bean注解的name/value属性指定bean名称，如果未指定，默认是方法名
    public SAXReader saxReader(GetData getData){    // 自动根据参数类型，完成第三方Bean所需的依赖注入
        System.out.println(getData);    // com.example.springbootappdemo.service.impl.GetData@7698b7a4
        return new SAXReader();
    }
}
