package com.lianci.controller;


import com.lianci.pojo.PageResult;
import com.lianci.pojo.Result;
import com.lianci.pojo.Student;
import com.lianci.pojo.StudentQueryParam;
import com.lianci.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping
    public Result page(StudentQueryParam studentQueryParam) {
        log.info("查询所有学生");
        PageResult<Student> PageResult = studentService.page(studentQueryParam);
        return Result.success(PageResult);
    }
}
