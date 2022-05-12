package com.syning.boot.boot05web03.controller;

import com.syning.boot.boot05web03.entity.Emp;
import com.syning.boot.boot05web03.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;


@Controller
public class EmpController {


    @Autowired
    EmpService empService;


    @GetMapping(value = "/emp")
    public String getEmpList(Model model) {

        List<Emp> empList = empService.getEmpList();

        model.addAttribute("empList", empList);

        return "emp_table";
    }


    @PostMapping(value = "/emp")
    public String insertEmp(Emp emp) {


        empService.insertEmp(emp);

        return "redirect:/emp";
    }


    @GetMapping(value = "/update/{id}")
    public String toUpdateEmp(@PathVariable("id") Integer id,
                              Model model) {
        Emp emp = empService.getEmpById(id);
        model.addAttribute("emp", emp);
        return "update_emp";
    }


    @PutMapping(value = "/emp")
    public String updateEmp(Emp emp) {

        empService.updateEmp(emp);

        return "redirect:/emp";
    }


    @GetMapping(value = "/del/{id}")
    public String delEmp(@PathVariable("id") Integer id) {
        empService.delEmpById(id);

        return "redirect:/emp";
    }


}
