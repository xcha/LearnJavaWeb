package com.lianci.controller;

import com.lianci.pojo.Emp;
import com.lianci.pojo.EmpQueryParam;
import com.lianci.pojo.PageResult;
import com.lianci.pojo.Result;
import com.lianci.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/emps")
public class EmpController {

    @Autowired
    private EmpService empService;

//    @GetMapping
//    public Result list(@RequestParam(defaultValue = "1")  Integer list, @RequestParam(defaultValue = "10") Integer pageSize,
//                       String name,
//                       Integer gender,
//                       @DateTimeFormat(pattern = "yyyy-mm-dd") LocalDate begin,
//                       @DateTimeFormat(pattern = "yyyy-mm-dd") LocalDate end) {
//        log.info("分页查询:{},{},{},{},{},{}",  list, pageSize, name, gender, begin, end);
//        PageResult<Emp> pageResult = empService.list(list, pageSize, name, gender, begin, end);
//        return Result.success(pageResult);
//    }
    @GetMapping
    public Result page(EmpQueryParam empQueryParam)  {
        log.info("分页查询:{}", empQueryParam);
        PageResult<Emp> pageResult = empService.page(empQueryParam);
        return Result.success(pageResult);
    }

    @GetMapping("/list")
     public Result list() {
        log.info("查询所有员工");
        List<Emp> empList = empService.list();
        return Result.success(empList);
    }

    @PostMapping
    public Result save(@RequestBody Emp emp) {
        log.info("添加员工:{}", emp);
        empService.save(emp);
        return Result.success();
    }

    @DeleteMapping
    public Result delete(@RequestParam List<Integer> ids) {
        log.info("批量删除员工:{}", ids);
        empService.delete(ids);
        return Result.success();
    }

    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id) {
        log.info("根据id查询员工信息:{}", id);
        Emp emp = empService.getById(id);
        return Result.success(emp);
    }

    @PutMapping
    public Result update(@RequestBody Emp emp) {
        log.info("修改员工信息:{}", emp);
        empService.update(emp);
        return Result.success();
    }
}
