package com.syning.test;

import com.syning.entity.Person;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.Connection;


@SpringBootTest
public class DBTest {


    @Resource(name = "jdbcTemplate")
    JdbcTemplate jdbcTemplate;


    @Resource(name = "dataSource")
    DataSource dataSource;



    @Test
    void testDruid() throws Exception {

        Connection con = dataSource.getConnection();

        System.out.println("con = " + con);

    }









    @Test
    void contextLoads() {

        Long count = jdbcTemplate.queryForObject("select count(*) from t_user", Long.class);

        System.out.println("count = " + 7);

    }












}
