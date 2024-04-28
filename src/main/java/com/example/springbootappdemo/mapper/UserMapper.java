package com.example.springbootappdemo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.springbootappdemo.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;
@Mapper
public interface UserMapper extends BaseMapper<User> {
    // 查询所有用户
    @Select("select * from user")
    public List<User> list();

    // 增加一个用户，返回插入用户的成功条数
    @Insert("insert into user values (#{id},#{name},#{age})")
    public int insert(User user);

    // 删除
    @Delete("delete from user where id=#{id}")
    public int delete(int id);

    // 修改
    @Update("update user set name=#{name} ,age=#{age} where id=#{id}")
    public int update(User user);

    // 查询
    @Select("select * from user where id=#{id}")
    public User find(int id);

    public User findByName(String name);

    public List<User> searchList(@Param("name") String name, @Param("ageL") int ageL, @Param("ageR") int ageR);

    public int updateDetail(String name, int age,int id);

    public int deleteByIds(@Param("ids") List<Integer> ids);
}
