package com.syning.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.syning.entity.Person;
import com.syning.entity.User;
import com.syning.service.PersonService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class TableController {

    @Resource(name = "personServiceImpl")
    private PersonService personService;


    @GetMapping("/basic")
    public String basic_table() {

        return "table/basic_table";
    }

    @GetMapping("/dynamic")
    public String dynamic(Model model,
                          @RequestParam(value = "pn", defaultValue = "1") Integer pn) {

//        // 表格内容的遍历
//        List<User> users = Arrays.asList(new User("宁", "0310"),
//                new User("霞", "0306"),
//                new User("月", "0216"),
//                new User("颜", "0310"));
//        model.addAttribute("users", users);


        // MyBatis-Plus
        // 从数据库中查出 t_person 表的用户进行展示
//        List<Person> persons = personService.list();
//        model.addAttribute("persons", persons);



        // 分页数据查询
        // pn 为页码，2 为显示条数
        Page<Person> personPage = new Page<>(pn, 2);

        // page 是分页查询的结果
        Page<Person> page = personService.page(personPage, null);

        // page 对象中封装了很多信息，如：总页码，当前页面，所有记录
        model.addAttribute("page", page);

        return "table/dynamic_table";
    }






}
