package com.lianci.mapper;

import com.lianci.pojo.Emp;
import com.lianci.pojo.EmpQueryParam;
import com.lianci.pojo.JobOption;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

@Mapper
public interface EmpMapper {


//    @Select("select count(*) from emp e left join dept d on e.dept_id =d.id")
//    public Long count();
//
//    @Select("select e.*,d.name deptName from emp e left join dept d on e.dept_id =d.id order by e.update_time desc limit #{start},#{pageSize}")
//    public List<Emp> list(Integer start, Integer pageSize);
//    @Select("select e.*,d.name deptName from emp e left join dept d on e.dept_id =d.id order by e.update_time desc ")

//   List<Emp> list(@Param("name") String name, @Param("gender") Integer gender, @Param("begin") LocalDate begin, @Param("end") LocalDate end);
   List<Emp> list(EmpQueryParam  empQueryParam);

   @Options (useGeneratedKeys = true,keyProperty = "id")// 设置主键回填
   @Insert("insert into emp(username,name,gender,phone,job,salary,image,entry_date,dept_id,create_time,update_time)" +
        " values (#{username},#{name},#{gender},#{phone},#{job},#{salary},#{image},#{entryDate},#{deptId},#{createTime},#{updateTime})")
   void insert(Emp emp);

   void deleteByIds(List<Integer> ids);

   Emp getById(Integer id);

   void updateById(Emp emp);

   @MapKey("pos")
   List<Map<String,Object>> countEmpJobDate();

   @MapKey("name")
   List<Map<String,Object>> countEmpGenderData();

   @Select("select id, username, password, name, gender, phone, job, salary, image, entry_date, dept_id, create_time, update_time from emp")
   List<Emp> findAll();
}
