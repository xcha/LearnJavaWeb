package com.lianci.controller;


import com.lianci.pojo.PageResult;
import com.lianci.pojo.Result;
import com.lianci.pojo.Student;
import com.lianci.pojo.StudentQueryParam;
import com.lianci.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    public Result save(@RequestBody Student student) {
        log.info("保存学生信息");
        studentService.save(student);
        return Result.success();
    }

    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id) {
        log.info("查询学生信息");
        Student student = studentService.getById(id);
        return Result.success(student);
    }

    @PutMapping
    public Result update(@RequestBody Student student) {
        log.info("更新学生信息");
        studentService.update(student);
        return Result.success();
    }
    @DeleteMapping("/{ids}")
    public Result delete(@PathVariable List<Integer> ids) {
        log.info("删除学生信息");
        studentService.delete(ids);
        return Result.success();
    }

    @PutMapping("/violation/{id}/{score}")
    public Result updateViolation(@PathVariable Integer id, @PathVariable Short score) {
        log.info("更新学生信息");
        studentService.updateViolation(id, score);
        return Result.success();
    }


}
