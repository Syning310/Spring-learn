package com.syning.service;

import com.syning.entity.User;
import com.syning.entity.UserExample;
import com.syning.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {


    @Autowired
    private UserMapper userMapper;


    @Transactional(readOnly = true)
    public User loginByNamePwd(String name, String pwd) {

        // 通过 QBC 查询方式，封装查询条件
        UserExample example = new UserExample();

        UserExample.Criteria criteria = example.createCriteria();

        // 封装条件
        criteria.andNameEqualTo(name).andPwdEqualTo(pwd);

        // 执行方法
        List<User> lst = userMapper.selectByExample(example);

        if (lst != null && lst.size() > 0) {
            // 直接返回查询结果
            return lst.get(0);
        }

        return null;
    }


    @Transactional(readOnly = true)
    public User getUserById(Integer id) {
        UserExample example = new UserExample();
        example.createCriteria().andIdEqualTo(id);

        List<User> lst = userMapper.selectByExample(example);

        // 如果 lst 为空，说明数据库中没有此条数据
        if (lst != null && lst.size() > 0) {
            return lst.get(0);
        }

        return null;
    }




}
