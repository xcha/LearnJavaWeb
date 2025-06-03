package com.lianci.mapper;

import com.lianci.pojo.Clazz;
import com.lianci.pojo.ClazzQueryParam;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ClazzMapper {

    List<Clazz> findAll() ;

    List<Clazz> list(ClazzQueryParam clazzQueryParam);

    void update(Clazz clazz);

    void insert(Clazz clazz);

    Clazz getById(Integer id);

    @Delete("delete from clazz where id = #{id}")
    void deleteById(Integer id);
}
