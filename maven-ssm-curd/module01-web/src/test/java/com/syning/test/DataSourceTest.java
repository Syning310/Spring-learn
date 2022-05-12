package com.syning.test;


import com.syning.entity.Message;
import com.syning.entity.User;
import com.syning.mapper.MessageMapper;
import com.syning.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;


// Spring 和 junit5 整合
@ExtendWith(SpringExtension.class)
@ContextConfiguration(value = {"classpath:spring-persist.xml"})
public class DataSourceTest {

    @Autowired
    private DataSource dataSource;

    @Autowired
    UserMapper userMapper;

    @Autowired
    MessageMapper messageMapper;

    @Test
    public void getUserList() {

        List<User> userList = userMapper.selectByExample(null);
        for (User u : userList) {
            System.out.println(u);
        }
    }


    @Test
    public void getMessageList() {

        List<Message> messageList = messageMapper.selectByExample(null);
        for (Message m : messageList) {
            System.out.println(m);
        }
    }


    @Test
    public void testDataSource() throws SQLException {
        Connection connection = dataSource.getConnection();
        System.out.println("connection = " + connection);
    }





}
