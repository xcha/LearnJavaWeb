package com.lianci.service;

import com.lianci.pojo.ClazzCountOption;
import com.lianci.pojo.PageResult;
import com.lianci.pojo.Student;
import com.lianci.pojo.StudentQueryParam;

import java.util.List;

public interface StudentService {
    PageResult<Student> page(StudentQueryParam  studentQueryParam);

    void save(Student student);

    Student getById(Integer id);

    void update(Student student);

    void delete(List<Integer> ids);

    void updateViolation(Integer id, Short score);

    ClazzCountOption getStudentCountData();
}
