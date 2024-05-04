package com.example.springbootappdemo.testEqual;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class Equal {
    public static final String[] strs = {"123","456"};

    public void copy(String[] sss){
        if(sss == strs){
            System.out.println("居然相等");
        }
    }
    @Test
    public void testEqual(){
        copy(strs);
    }
}
