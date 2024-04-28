package com.example.springbootappdemo;

import com.example.springbootappdemo.entity.Goods;
import com.example.springbootappdemo.entity.User;
import com.example.springbootappdemo.mapper.GoodsMapper;
import com.example.springbootappdemo.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
class SpringBootAppDemoApplicationTests {
    @Autowired
    GoodsMapper goodsMapper;
    @Autowired
    UserMapper userMapper;
    private List<Goods> goodsList;
    private User user;

    @Test
    void TestListGoods() {
        goodsList = goodsMapper.selectGoodsAndOrder();
        goodsList.stream().forEach((Good)->{
                    System.out.println(Good);
                }
        );
    }
    @Test
    void TestFindUserByName() {
        user = userMapper.findByName("cfd");
        System.out.println(user);
    }
    @Test
    void TestSerachList(){
        List<User> cfd = userMapper.searchList(null,18,18);
//        cfd.stream().forEach((user)->{
                    System.out.println(user);
//                }
//        );
    }
    @Test
    void TestDeleteIds(){
        List<Integer> list = Arrays.asList(12,13,14);
        userMapper.deleteByIds(list);
    }
}
