package com.lianci.service.Impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.lianci.mapper.EmpExprMapper;
import com.lianci.mapper.EmpMapper;
import com.lianci.pojo.Emp;
import com.lianci.pojo.EmpExpr;
import com.lianci.pojo.EmpQueryParam;
import com.lianci.pojo.PageResult;
import com.lianci.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {
    @Autowired
    private EmpMapper empMapper;

    @Autowired
    private EmpExprMapper empExprMapper;
//    @Override
//    public PageResult<Emp> page(Integer page, Integer pageSize) {
//    Long total = empMapper.count();
//    Integer  start = (page - 1) * pageSize;
//    List<Emp> rows = empMapper.list(start, pageSize);
//
//    return new PageResult<>(total,rows);

//    @Override
//    public PageResult<Emp> page(Integer page, Integer pageSize, String name, Integer gender, LocalDate begin, LocalDate end) {
//        PageHelper.startPage(page,pageSize);
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

    @Override
    public void save(Emp emp) {
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
    }
}
