package com.lianci.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageResult<T> {
    private Long total;// 总数
    private List<T> rows;// 数据
}
