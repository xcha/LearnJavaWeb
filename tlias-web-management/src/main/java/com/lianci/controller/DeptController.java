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
        System.out.println("depts list");
        List<Dept> deptsList =deptService.findAll();
        return Result.success(deptsList);
    }

    @DeleteMapping("/depts")
    public Result delete(Integer id){
       System.out.println("delete deptId="+id);
       deptService.deleteById(id);
       return Result.success();
    }

    @PostMapping("/depts")
    public Result add(@RequestBody  Dept dept){//  @RequestBody  将json数据按对应属性转为java对象
        System.out.println("add dept="+dept);
        deptService.add(dept);
        return Result.success();
    }

    @GetMapping("/depts/{id}")
    public Result getInfo(@PathVariable Integer deptId){
        System.out.println("getInfo deptId="+ deptId);
        Dept dept = deptService.getInfo(deptId);
        return Result.success(dept);
    }

    @PutMapping("/depts")
    public Result update(@RequestBody Dept dept){
        deptService.update(dept);
        return Result.success();
    }
}
