package com.example.springbootappdemo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.springbootappdemo.entity.Role;
import com.example.springbootappdemo.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface RoleMapper extends BaseMapper<Role> {
    @Select("select * from role where id=#{id}")
    public Role find(Long id);

    public Integer create(Role role);
}
