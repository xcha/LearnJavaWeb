package com.lianci.service;

import com.lianci.pojo.Emp;
import com.lianci.pojo.EmpQueryParam;
import com.lianci.pojo.LoginInfo;
import com.lianci.pojo.PageResult;

import java.time.LocalDate;
import java.util.List;

public interface EmpService {
//    PageResult<Emp> list(Integer list, Integer pageSize, String name, Integer gender, LocalDate begin, LocalDate end);
    PageResult<Emp> page(EmpQueryParam empQueryParam);

    void save(Emp emp);

    void delete(List<Integer> ids);

    Emp getById(Integer id);

    void update(Emp emp);

    List<Emp> list();

    LoginInfo login(Emp emp);
}
