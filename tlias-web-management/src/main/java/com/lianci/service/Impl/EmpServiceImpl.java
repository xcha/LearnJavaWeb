package com.lianci.service.Impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.lianci.mapper.EmpExprMapper;
import com.lianci.mapper.EmpMapper;
import com.lianci.pojo.*;
import com.lianci.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {
    @Autowired
    private EmpMapper empMapper;

    @Autowired
    private EmpExprMapper empExprMapper;

    @Autowired
    private EmpLogServiceImpl empLogService;
//    @Override
//    public PageResult<Emp> list(Integer list, Integer pageSize) {
//    Long total = empMapper.count();
//    Integer  start = (list - 1) * pageSize;
//    List<Emp> rows = empMapper.list(start, pageSize);
//
//    return new PageResult<>(total,rows);

//    @Override
//    public PageResult<Emp> list(Integer list, Integer pageSize, String name, Integer gender, LocalDate begin, LocalDate end) {
//        PageHelper.startPage(list,pageSize);
//        List<Emp> empList = empMapper.list(name, gender, begin, end);
//        Page<Emp> p= (Page<Emp>) empList;
//        return new PageResult<Emp>(p.getTotal(), p.getResult());
//    }

    @Override
    public PageResult<Emp> page(EmpQueryParam  empQueryParam) {
        PageHelper.startPage(empQueryParam.getPage(),empQueryParam.getPageSize());
        List<Emp> empList = empMapper.list(empQueryParam);
        Page<Emp> p= (Page<Emp>) empList;
        return new PageResult<Emp>(p.getTotal(), p.getResult());
    }

    @Transactional(rollbackFor = Exception.class)  // 事务注解
    @Override
    public void save(Emp emp) {
        try {
            emp.setCreateTime(LocalDateTime.now());
            emp.setUpdateTime(LocalDateTime.now());
            empMapper.insert(emp);


            List<EmpExpr> exprList= emp.getExprList();
            if(!CollectionUtils.isEmpty (exprList)){
                 exprList.forEach(exprExpr ->{
                    exprExpr.setEmpId(emp.getId());
                   });
                empExprMapper.insertBatch(exprList);
            }
        } finally {
            EmpLog  empLog = new EmpLog(null,LocalDateTime.now(),"新增员工："+emp.getName());
            empLogService.insertLog(empLog);
        }

    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(List<Integer> ids) {
        empMapper.deleteByIds(ids);
        empExprMapper.deleteByEmpIds(ids);
    }

    @Override
    public Emp getById(Integer id) {
        return empMapper.getById(id);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void update(Emp emp) {
        emp.setUpdateTime(LocalDateTime.now());
        empMapper.updateById(emp);
        empExprMapper.deleteByEmpIds(Arrays.asList(emp.getId()));
        List<EmpExpr> exprList= emp.getExprList();
         if(!CollectionUtils.isEmpty (exprList)){
            exprList.forEach(empExpr -> empExpr.setEmpId(emp.getId()));
            empExprMapper.insertBatch(exprList);
        }
    }

    @Override
    public List<Emp> list() {
        return empMapper.findAll();
    }
}
