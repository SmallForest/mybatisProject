package com.yangsen.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Blog {
    private String id;
    private String title;
    private String author;
    private LocalDateTime createTime;//数据库create_time,需要开启mybatis驼峰名字自动转换=true
    private int views;
}
