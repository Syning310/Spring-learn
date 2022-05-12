package com.syning.boot.boot05web03.service;

import com.syning.boot.boot05web03.entity.Emp;
import com.syning.boot.boot05web03.mapper.EmpMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpService {

    @Autowired
    private EmpMapper mapper;


    public List<Emp> getEmpList() {
        return mapper.getAllEmp();
    }


    public void insertEmp(Emp emp) {
        mapper.insertEmp(emp);
    }


    public Emp getEmpById(Integer id) {
        return mapper.getEmpById(id);
    }


    public void updateEmp(Emp emp) {
        mapper.updateEmp(emp);
    }


    public void delEmpById(Integer id) {
        mapper.deleteEmpById(id);
    }


}
