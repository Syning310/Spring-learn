package com.syning.test;

import com.syning.entity.Person;
import com.syning.mapper.PersonMapper;
import com.syning.service.PersonService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;


@SpringBootTest
public class TestMybatisPlus {


    @Resource
    PersonMapper personMapper;

    @Resource
    PersonService personService;

    @Test
    void testPersonMapper() {
        Person p1 = personMapper.selectById(1);

        System.out.println(p1);
    }



    @Test
    void getPersonList() {

        // 必须以这个类的对象来调用方法，事务才会生效
        new TestMybatisPlus().addPerson();

        List<Person> persons = personService.list();

        for (Person p : persons) {
            System.out.println(p);
        }

    }


    @Transactional
    @Test
    void addPerson() {

        Person p1 = new Person(2, "霞", "1222", 8, "女");

        personService.updateById(p1);

        throw new RuntimeException();

    }







}
