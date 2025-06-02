package com.lianci.service;

import com.lianci.pojo.Clazz;
import com.lianci.pojo.ClazzQueryParam;
import com.lianci.pojo.PageResult;

import java.util.List;

public interface ClazzService {
    PageResult<Clazz> page(ClazzQueryParam clazzQueryParam);

    List<Clazz> list();

    void save(Clazz clazz);

    Clazz getById(Integer id);

    void update(Clazz clazz);

    void delete(Integer id);
}
