package com.lianci.controller;

import com.lianci.pojo.Dept;
import com.lianci.pojo.Result;
import com.lianci.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController//  返回json数据
@Slf4j
public class DeptController {

    @Autowired// 自动注入
    private DeptService deptService;

    @GetMapping("/depts")
        public Result list(){
        System.out.println("部门表：");
        List<Dept> deptsList =deptService.findAll();
        return Result.success(deptsList);
    }

    @DeleteMapping("/depts")
    public Result delete(Integer id){
       System.out.println("删除部门ID：="+id);
       deptService.deleteById(id);
       return Result.success();
    }

    @PostMapping("/depts")
    public Result add(@RequestBody  Dept dept){//  @RequestBody  将json数据按对应属性转为java对象
        System.out.println("添加部门="+dept);
        deptService.add(dept);
        return Result.success();
    }

    @GetMapping("/depts/{id}")
    public Result getInfo(@PathVariable Integer id){
        System.out.println("根据ID查询部门"+ id);
        Dept dept = deptService.getInfo(id);
        return Result.success(dept);
    }

    @PutMapping("/depts")
    public Result update(@RequestBody Dept dept){
        deptService.update(dept);
        return Result.success();
    }
}
