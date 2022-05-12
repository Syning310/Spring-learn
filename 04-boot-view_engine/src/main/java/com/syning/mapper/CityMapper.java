package com.syning.mapper;

import com.syning.entity.City;
import org.apache.ibatis.annotations.*;

//@Mapper
public interface CityMapper {

    @Insert("insert into city (`name`, state) values (#{city.name}, #{city.state})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insertCity(@Param("city") City city);

    @Select("select id, `name`, state from city where id = #{id}")
    City getCityById(@Param("id") Integer id);

}
