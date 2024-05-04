package com.example.springbootappdemo.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@TableName("role")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Role {
    private Long id;
    private String name;
    /** 角色权限 */
    private String key;
    /** 角色排序 */
    private Integer sort;
}
