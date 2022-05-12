package com.syning.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.syning.entity.Person;
import com.syning.mapper.PersonMapper;
import com.syning.service.PersonService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service(value = "personServiceImpl")
public class PersonServiceImpl extends ServiceImpl<PersonMapper, Person> implements PersonService {

}
