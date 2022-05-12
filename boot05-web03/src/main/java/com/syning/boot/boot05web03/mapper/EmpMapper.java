package com.syning.boot.boot05web03.mapper;


import com.syning.boot.boot05web03.entity.Emp;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface EmpMapper {

    @Select("SELECT id, `name`, pwd, age, sex FROM t_user")
    List<Emp> getAllEmp();



    @Insert("insert into t_user (name,pwd,age,sex) values (#{emp.name}, #{emp.pwd}, #{emp.age}, #{emp.sex})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insertEmp(@Param("emp") Emp emp);


    @Select("select id, name, pwd, age, sex from t_user where id = #{id}")
    Emp getEmpById(@Param("id") Integer id);



    @Update("update t_user set name = #{emp.name}, pwd = #{emp.pwd}, age = #{emp.age}, sex = #{emp.sex} where id = #{emp.id}")
    int updateEmp(@Param("emp") Emp emp);



    @Delete("delete from t_user where id = #{id}")
    int deleteEmpById(@Param("id") Integer id);


}
