package com.lianci.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClazzQueryParam {
    private Integer page=1;
    private Integer pageSize=10;
    private String name;
    @DateTimeFormat(pattern = "yyyy-mm-dd")// 格式化日期
    private LocalDate begin;
    @DateTimeFormat (pattern = "yyyy-mm-dd")
    private LocalDate end;
}
