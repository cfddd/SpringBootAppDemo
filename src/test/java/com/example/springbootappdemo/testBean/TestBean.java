package com.example.springbootappdemo.testBean;

import com.example.springbootappdemo.demos.Contorller.TestBeanController;
import com.example.springbootappdemo.service.impl.GetData;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

@SpringBootTest
public class TestBean {
    @Autowired
    private ApplicationContext applicationContext;  // IOC 容器对象
    private Object testBeanController;

    @Test
    public void testGetBean(){
        testBeanController = applicationContext.getBean("testBeanController");
        System.out.println(testBeanController);
        testBeanController = applicationContext.getBean(TestBeanController.class);
        System.out.println(testBeanController);
        testBeanController = applicationContext.getBean("testBeanController",TestBeanController.class);
        System.out.println(testBeanController);
        // com.example.springbootappdemo.demos.Contorller.TestBeanController@4a9b3956
        // com.example.springbootappdemo.demos.Contorller.TestBeanController@4a9b3956
        // com.example.springbootappdemo.demos.Contorller.TestBeanController@4a9b3956
    }

    @Test
    public void testScope(){
        for (int i = 0; i < 10; i++) {
            testBeanController = applicationContext.getBean("testBeanController");
            System.out.println(testBeanController);
        }
        // 默认自动初始化Bean
        /*
        Constructor run ...
        间隔一段时间，运行单侧内容后
        com.example.springbootappdemo.demos.Contorller.TestBeanController@4a9b3956 * 10 ...
         */
        // 使用@lazy 使用时才会初始化Bean容器
        /*
        Constructor run ...
        com.example.springbootappdemo.demos.Contorller.TestBeanController@2e45a357
        */
        // 使用@Scope("prototype")，每次获取Bean都重新初始化
        /*
        Constructor run ...
        com.example.springbootappdemo.demos.Contorller.TestBeanController@203b953c
        Constructor run ...
        com.example.springbootappdemo.demos.Contorller.TestBeanController@730bea0
        ...
         */

    }
    @Autowired
    private SAXReader saxReader;
    @Test
    public void testThirdBean() throws DocumentException {
        Document document = saxReader.read(this.getClass().getClassLoader().getResource("data/cfd.xml"));
        Element rootElement = document.getRootElement();
        String name = rootElement.element("name").getText();
        String age = rootElement.element("age").getText();

        System.out.println("name : " + name);
        System.out.println("age : " + age);
    }
    @Test
    public void getThirdBean(){
        Object saxReader = applicationContext.getBean("saxReader");
        System.out.println(saxReader);  // org.dom4j.io.SAXReader@52f9e8bb
    }
}
