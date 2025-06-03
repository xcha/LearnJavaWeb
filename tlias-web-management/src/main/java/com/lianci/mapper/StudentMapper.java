package com.lianci.mapper;


import com.lianci.pojo.ClazzCountOption;
import com.lianci.pojo.Student;
import com.lianci.pojo.StudentQueryParam;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Mapper
public interface StudentMapper {
    List<Student> list(StudentQueryParam studentQueryParam);

    void insert(Student student);

    Student getById(Integer id);

    void update(Student student);

    void deleteByIds(List<Integer> ids);

    void updateViolation(Integer id, Short score);

    @MapKey("name")
    List<Map> countStudentDegreeData();

    @Select("select count(*) from student where clazz_id = #{id}")
    Integer countByClazzId(Integer id);
    /**
     * 统计班级人数
     */
    @Select("select c.name cname , count(s.id) scount from clazz c  left join student s on s.clazz_id = c.id group by c.name order by count(s.id) desc ")
    List<Map<String,Object>> getStudentCount();


}
