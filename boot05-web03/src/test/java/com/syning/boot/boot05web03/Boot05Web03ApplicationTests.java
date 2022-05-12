package com.syning.boot.boot05web03;

import com.syning.boot.boot05web03.entity.Book;
import com.syning.boot.boot05web03.mapper.BookMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

@Slf4j
@SpringBootTest
class Boot05Web03ApplicationTests {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    DataSource dataSource;

    @Autowired
    BookMapper mapper;

    @Test
    void contextLoads() {

        Long along = jdbcTemplate.queryForObject("select count(*) from book", Long.class);

        System.out.println("总共有{ " + along + " }条记录");


        log.info("数据源类型：{}", dataSource.getClass());

    }

    @Test
    void testGetAll() {

        List<Book> list = mapper.getAllBook();

        list.forEach(book -> {
            System.out.println(book);
        });


    }





}
