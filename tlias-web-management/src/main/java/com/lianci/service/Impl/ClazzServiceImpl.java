package com.lianci.service.Impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.lianci.exception.BusinessException;
import com.lianci.mapper.ClazzMapper;
import com.lianci.mapper.StudentMapper;
import com.lianci.pojo.Clazz;
import com.lianci.pojo.ClazzQueryParam;
import com.lianci.pojo.PageResult;
import com.lianci.service.ClazzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ClazzServiceImpl implements ClazzService {
    @Autowired
    private ClazzMapper clazzMapper;

    @Autowired
    private StudentMapper studentMapper;

//    @Override
//    public PageResult <Clazz> list(ClazzQueryParam clazzQueryParam){
//        PageHelper.startPage(clazzQueryParam.getPage(), clazzQueryParam.getPageSize());
//        List<Clazz> clazzList = clazzMapper.list(clazzQueryParam);// 查询所有
////        如果当前时间 在班级的开课时间之后，则将班级状态改为未开课
////        如果 当前时间 在班级的结束时间之前，则将班级状态改为已结课
////        如果 当前时间 在班级的开课时间之后 节课时间之前，则将班级状态改为在读中
////        clazzList.forEach(clazz -> {
////             if (clazz.getBeginDate().isBefore(ChronoLocalDate.from(LocalDateTime.now())) && clazz.getEndDate().isAfter(ChronoLocalDate.from(LocalDateTime.now()))) {
////                clazz.setStatus("在读");
////            } else if (clazz.getBeginDate().isAfter(ChronoLocalDate.from(LocalDateTime.now()))) {
////                clazz.setStatus("未开课");
////            } else if (clazz.getEndDate().isBefore(ChronoLocalDate.from(LocalDateTime.now()))) {
////                clazz.setStatus("已结课");
////            }
////        });
//        Page <Clazz> p = (Page<Clazz>) clazzList;// 将查询结果转为Page对象
//        return new PageResult<Clazz>(p.getTotal(), p.getResult());// 返回分页结果
//    }

@Override
public PageResult page(ClazzQueryParam clazzQueryParamnteger) {

    PageHelper.startPage(clazzQueryParamnteger.getPage(),clazzQueryParamnteger.getPageSize());

    List<Clazz> dataList = clazzMapper.list(clazzQueryParamnteger);
    Page<Clazz> p = (Page<Clazz>) dataList;

    return new PageResult(p.getTotal(), p.getResult());
}


    @Override
    public List<Clazz> list() {
        return clazzMapper.findAll();
    }

    @Override
    public void save(Clazz clazz) {
        clazz.setCreateTime(LocalDateTime.now());
        clazz.setUpdateTime(LocalDateTime.now());
        clazzMapper.insert(clazz);
    }

    @Override
    public Clazz getById(Integer id) {
        return  clazzMapper.getById(id);
    }

    @Override
    public void update(Clazz clazz) {
        clazz.setUpdateTime(LocalDateTime.now());
        clazzMapper.update(clazz);
    }

    @Override
    public void deleteById(Integer id) {
        //1. 查询班级下是否有学员
        Integer count = studentMapper.countByClazzId(id);
        if(count > 0){
            throw new BusinessException("班级下有学员, 不能直接删除~");
        }
        //2. 如果没有, 再删除班级信息
        clazzMapper.deleteById(id);
    }

}
