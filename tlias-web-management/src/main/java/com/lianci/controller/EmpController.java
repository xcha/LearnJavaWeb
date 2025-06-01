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
//    public Result page(@RequestParam(defaultValue = "1")  Integer page, @RequestParam(defaultValue = "10") Integer pageSize,
//                       String name,
//                       Integer gender,
//                       @DateTimeFormat(pattern = "yyyy-mm-dd") LocalDate begin,
//                       @DateTimeFormat(pattern = "yyyy-mm-dd") LocalDate end) {
//        log.info("分页查询:{},{},{},{},{},{}",  page, pageSize, name, gender, begin, end);
//        PageResult<Emp> pageResult = empService.page(page, pageSize, name, gender, begin, end);
//        return Result.success(pageResult);
//    }
    @GetMapping
    public Result page(EmpQueryParam empQueryParam)  {
        log.info("分页查询:{}", empQueryParam);
        PageResult<Emp> pageResult = empService.page(empQueryParam);
        return Result.success(pageResult);
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
}
