package com.example.springbootappdemo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.util.List;

@TableName("order")
public class Order {
    @TableId(type= IdType.AUTO)
    private int id;
    private int good_id;
    private int amount;
    @TableField(exist = false)//表示不存在，忽略这个字端上的操作，导入需要自行编写
    private Goods good;

    public Goods getGood() {
        return good;
    }

    public void setGood(Goods good) {
        this.good = good;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getGood_id() {
        return good_id;
    }

    public void setGood_id(int good_id) {
        this.good_id = good_id;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", good_id=" + good_id +
                ", amount=" + amount +
                ", good=" + good +
                '}';
    }
}
