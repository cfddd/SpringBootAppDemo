package com.example.springbootappdemo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.springbootappdemo.entity.Log;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LogMapper extends BaseMapper<Log> {
    // INSERT INTO `spring_demo`.`log` (`id`, `operator_id`, `create_at`, `class_name`, `method_name`, `method_args`, `method_value`, `return_value`, `cost`)
    // VALUES ('1', '1', '1', '1', '1', '1', '1', '1', '1');
    @Insert("insert into log (`operator_id`, `create_at`, `class_name`, `method_name`, `method_args`, `return_value`, `cost`)" +
            "values (#{operatorId},#{createAt},#{className},#{methodName},#{methodArgs},#{returnValue},#{costTime})")
    public int create(Log log);
}
