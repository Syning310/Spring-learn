package com.syning.boot.boot05web03.mapper;

import com.syning.boot.boot05web03.entity.Book;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface BookMapper {

    // 在配置文件中
    List<Book> getAllBook();



    // 利用注解
    @Select("select * from book where id = #{id}")
    Book getBookById(@Param("id") Integer id);


}
