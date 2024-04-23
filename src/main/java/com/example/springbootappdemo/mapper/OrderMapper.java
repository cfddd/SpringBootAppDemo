package com.example.springbootappdemo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.springbootappdemo.entity.Goods;
import com.example.springbootappdemo.entity.Order;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface OrderMapper extends BaseMapper<Order> {
    @Select("select * from `order` where good_id=#{good_id}")
    List<Order> selectByGoodId(int good_id);
    // order 是关键词，加``防止出问题
    @Select("select * from `order`")
    @Results(   // Result 注意单复数，使用后必须自己完成映射
            {
                    @Result(column = "id",property = "id"), // column表示表里的数据列，property表示结构体里的字段
                    @Result(column = "amount",property = "amount"),
                    @Result(column = "good_id",property = "good_id"),
                    @Result(column = "good_id",property = "good",javaType = Goods.class,    //javaType告诉返回值是一个列表类型
                            one = @One(select = "com.example.springbootappdemo.mapper.GoodsMapper.selectGoodsById")
                            // @Many表示一对一的关系
                    )
            }
    )
    public List<Order> selectOrderAndGoods();
}
