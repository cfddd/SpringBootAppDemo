package com.example.springbootappdemo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MyResult<T> {
    private int code;
    private String message;
    private T data;
    // 静态方法，创建成功的Result对象
    public static <T> MyResult<T> success() {
        return new MyResult(200, "ok",null);}

    // 静态方法，创建带数据的成功的Result对象
    public static <T> MyResult<T> success(String message, T data) {
        return new MyResult<>(200, message, data);
    }

    // 静态方法，创建失败的Result对象
    public static <T> MyResult<T> error(int code, String message) {
        return new MyResult<>(code, message,null);
    }
}