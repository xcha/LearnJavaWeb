package com.lianci.service;

import com.lianci.pojo.PageResult;
import com.lianci.pojo.Student;
import com.lianci.pojo.StudentQueryParam;

import java.util.List;

public interface StudentService {
    PageResult<Student> page(StudentQueryParam  studentQueryParam);
}
