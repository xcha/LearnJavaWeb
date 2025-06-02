package com.lianci.controller;

import com.lianci.pojo.Clazz;
import com.lianci.pojo.ClazzQueryParam;
import com.lianci.pojo.PageResult;
import com.lianci.pojo.Result;
import com.lianci.service.ClazzService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping ("/clazzs")
public class ClazzController {
    @Autowired
    private ClazzService clazzService;

    @GetMapping
    public Result page(ClazzQueryParam clazzQueryParam) {
        log.info("分页查询:{}", clazzQueryParam);
        PageResult<Clazz> pageResult = clazzService.page(clazzQueryParam);
        return Result.success(pageResult);
    }

     @GetMapping("/list")
     public Result list() {
         log.info("查询所有班级");
         List<Clazz> clazzList = clazzService.list();
         return Result.success(clazzList);
     }

     @PostMapping
     public Result save(@RequestBody Clazz clazz) {
         log.info("新增班级:{}", clazz);
         clazzService.save(clazz);
         return Result.success();
     }

    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id) {
        log.info("查询id为{}的班级", id);
        Clazz clazz = clazzService.getById(id);
        return Result.success(clazz);
    }

    @PutMapping
    public Result update(@RequestBody Clazz clazz) {
        log.info("修改班级:{}", clazz);
        clazzService.update(clazz);
        return Result.success();
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        log.info("删除id为{}的班级", id);
        clazzService.delete(id);
        return Result.success();
    }


}
