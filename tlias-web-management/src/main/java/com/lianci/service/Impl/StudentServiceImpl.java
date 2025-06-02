package com.lianci.service.Impl;


import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.lianci.mapper.StudentMapper;
import com.lianci.pojo.PageResult;
import com.lianci.pojo.Student;
import com.lianci.pojo.StudentQueryParam;
import com.lianci.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public PageResult<Student> page(StudentQueryParam  studentQueryParam) {
        PageHelper.startPage(studentQueryParam.getPage(), studentQueryParam.getPageSize());
        List<Student> dataList = studentMapper.list(studentQueryParam);
        Page<Student> p = (Page<Student>) dataList;
        return new PageResult<Student>(p.getTotal(), p.getResult());
    }
}
