package com.lianci.mapper;


import com.lianci.pojo.Student;
import com.lianci.pojo.StudentQueryParam;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Mapper
public interface StudentMapper {
    List<Student> list(StudentQueryParam studentQueryParam);
}
