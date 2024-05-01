package com.example.springbootappdemo.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.sf.jsqlparser.expression.DateTimeLiteralExpression;

import java.time.LocalDateTime;
import java.util.Date;
@TableName("log")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Log {
    private Integer id;
    private Integer operatorId;
    private LocalDateTime createAt;
    private String className;
    private String methodName;
    private String methodArgs;
    private String returnValue;
    private Long costTime;
}
