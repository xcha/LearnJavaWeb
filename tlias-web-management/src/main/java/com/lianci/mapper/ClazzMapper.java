package com.lianci.mapper;

import com.lianci.pojo.Clazz;
import com.lianci.pojo.ClazzQueryParam;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ClazzMapper {

    List<Clazz> findAll() ;


    List<Clazz> list(ClazzQueryParam clazzQueryParam);

    void update(Clazz clazz);

    void insert(Clazz clazz);

    Clazz getById(Integer id);

    void delete(Integer id);
}
