package com.lianci.service;

import com.lianci.pojo.Dept;

import java.util.List;

public interface DeptService {
    List<Dept> findAll();

    void deleteById(Integer id);

    void add(Dept dept);

    Dept getInfo(Integer deptId);

    void update(Dept dept);
}
