package com.lianci.service.Impl;

import com.lianci.mapper.EmpMapper;
import com.lianci.pojo.JobOption;
import com.lianci.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ReportServiceImpl implements ReportService {

    @Autowired
    private EmpMapper empMapper;

    @Override
    public JobOption getEmpJobData() {
        List<Map<String, Object>>list= empMapper.countEmpJobDate();
        List<Object>jobList= list.stream().map(dataMap-> dataMap.get( "pos")).toList();
        List<Object>dataList= list.stream().map(dataMap-> dataMap.get( "num")).toList();

        return new JobOption(jobList,dataList);
    }

    @Override
    public List<Map<String, Object>> getEmpGenderData() {
        return empMapper.countEmpGenderData();
    }

}
