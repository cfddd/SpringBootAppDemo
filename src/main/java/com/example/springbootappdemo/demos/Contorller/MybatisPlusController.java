package com.example.springbootappdemo.demos.Contorller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.springbootappdemo.entity.User;
import com.example.springbootappdemo.mapper.GoodsMapper;
import com.example.springbootappdemo.mapper.OrderMapper;
import com.example.springbootappdemo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MybatisPlusController {
    // 自动注入GoodsMapper
    @Autowired
    private GoodsMapper goodsMapper;
    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private UserMapper userMapper;
    @GetMapping("/goods")
    public List query(){
        return goodsMapper.selectGoods();
    }
    @GetMapping("/better_goods")
    public List betterGoodsQuery(){
        return goodsMapper.selectGoodsAndOrder();
    }
    @GetMapping("/better_order")
    public List betterOrdersQuery(){
        return orderMapper.selectOrderAndGoods();
    }
    // 条件查询
    @GetMapping("/user/find")
    public List<User> findByCond(String name){
        QueryWrapper<User> queueWarpper = new QueryWrapper<>();
        queueWarpper.eq("name",name);
        return userMapper.selectList(queueWarpper);
    }
    // 分页查询
    @GetMapping("/user/page")
    public IPage findPage(int page,int size){
        Page<User> config = new Page<>(page,size);
        IPage iPage = userMapper.selectPage(config,null);
        return iPage;
    }
}
