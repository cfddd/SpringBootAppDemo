package com.example.springbootappdemo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.springbootappdemo.entity.Goods;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface GoodsMapper extends BaseMapper<Goods> {

    @Select("select * from goods")  // 没有处理完全，连表没做
    public List<Goods> selectGoods();

    @Select("select * from goods where id=#{id}")   //该方法可不写，使用继承来的selectById做平替换
    public Goods selectGoodsById(int id);

    @Select("select * from goods")
    @Results(   // Result 注意单复数，使用后必须自己完成映射
            {
                    @Result(column = "id",property = "id"), // column表示表里的数据列，property表示结构体里的字段
                    @Result(column = "name",property = "name"),
                    @Result(column = "price",property = "price"),
                    @Result(column = "id",property = "orders",javaType = List.class,    //javaType告诉返回值是一个列表类型
                        many = @Many(select = "com.example.springbootappdemo.mapper.OrderMapper.selectByGoodId")
                            // @Many表示一对多的关系
                    )
            }
    )
    public List<Goods> selectGoodsAndOrder();

}
