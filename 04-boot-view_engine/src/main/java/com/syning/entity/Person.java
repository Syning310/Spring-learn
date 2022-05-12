package com.syning.entity;


import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;



@Data
@TableName("t_person")
public class Person {

    private Integer id;

    private String name;

    private String pwd;

    private Integer age;

    private String sex;

    public Person() {}

    public Person(Integer id, String name, String pwd, Integer age, String sex) {
        this.id = id;
        this.name = name;
        this.pwd = pwd;
        this.age = age;
        this.sex = sex;
    }
}
