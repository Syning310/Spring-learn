package com.syning.service;


import com.syning.entity.City;
import com.syning.mapper.CityMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class CityService {

    @Resource
    private CityMapper cityMapper;


    public int addCity(City city) {
        return cityMapper.insertCity(city);
    }

    public City getCityById(Integer id) {
        return cityMapper.getCityById(id);
    }

}
