package com.lianci.service;

import com.lianci.pojo.ClazzCountOption;
import com.lianci.pojo.JobOption;

import java.util.List;
import java.util.Map;

public interface ReportService {
    JobOption getEmpJobData();

    List<Map<String, Object>> getEmpGenderData();

    List<Map> getStudentDegreeData();

    ClazzCountOption getStudentCountData();
}
