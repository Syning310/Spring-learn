package com.syning.controller;


import com.syning.entity.City;
import com.syning.service.CityService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class CityController {

    @Resource
    private CityService cityService;


    @GetMapping("/insertcity")
    public City insertCity(City city) {
        cityService.addCity(city);
        return city;
    }

    @GetMapping("/getCity")
    public City getCityById(@RequestParam("id") Integer id) {
        return cityService.getCityById(id);
    }


}
