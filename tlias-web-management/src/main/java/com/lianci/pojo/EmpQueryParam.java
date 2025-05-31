package com.lianci.pojo;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
public class EmpQueryParam {
    private Integer page=1;
    private Integer pageSize=10;
     private String name;
     private Integer gender;
     @DateTimeFormat (pattern = "yyyy-mm-dd")// 格式化日期
     private LocalDate begin;
     @DateTimeFormat (pattern = "yyyy-mm-dd")
     private LocalDate end;
}
