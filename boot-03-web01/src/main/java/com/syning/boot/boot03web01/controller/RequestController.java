package com.syning.boot.boot03web01.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class RequestController {


    @GetMapping("/goto")
    public String goToPage(Model model) {

        model.addAttribute("msg", "跳转成功");
        model.addAttribute("code", 200);

        return "forward:/success";
    }


    @ResponseBody
    @GetMapping("/success")
    public Map<String, Object> success(HttpServletRequest request) {
        Map<String, Object> map = new HashMap<>();

        map.put("msg", request.getAttribute("msg"));
        map.put("code", request.getAttribute("code"));

        return map;
    }



    // SpringBoot 默认禁用了矩阵变量的功能(默认移除分号后面的内容)，需要手动开启: 对于整个路径的处理，UrlPathHelper 进行解析
    // removeSemicolonContent(移除分号内容) 支持矩阵变量的

    // 1、语法  /cars/sell;low=34;brand=byb,audi,yd        -->    路径就是 sell 分号后面的就是矩阵变量

    @ResponseBody
    @GetMapping(value = "/cars/{path}")
    public Map<String, Object> carsSell(@MatrixVariable("low") Integer low,
                                        @MatrixVariable("brand") List<String> brand,
                                        @PathVariable("path") String path) {
        Map<String, Object> map = new HashMap<>();

        map.put("low", low);
        map.put("brand", brand);
        map.put("path", path);

        return map;
    }



    // 2、语法    /boss/1;age=20/2;age=10

    // 矩阵变量必须要有 url 路径变量，如 /{boosId}/{empId}  才能够被解析
    @ResponseBody
    @GetMapping(value = "/boss/{bossId}/{empId}")
    public Map<String, Object> boss(@MatrixVariable(value = "age", pathVar = "bossId") Integer bossAge,
                                    @MatrixVariable(value = "age", pathVar = "empId") Integer empAge) {
        Map<String, Object> map = new HashMap<>();

        map.put("bossAge", bossAge);
        map.put("empAge", empAge);


        return map;
    }






    @GetMapping("/params")
    public String testParam(Map<String, Object> map,
                            Model model,
                            HttpServletRequest request,
                            HttpServletResponse response) {
        map.put("map", "hello map");
        model.addAttribute("model", "hello model");
        request.setAttribute("request", "hello request");


        return "forward:/testRequest";
    }


    @ResponseBody
    @GetMapping("/testRequest")
    public Map<String, Object> testRequest(HttpServletRequest request) {
        Map<String, Object> retMap = new HashMap<>();

        Object map = request.getAttribute("map");
        Object model = request.getAttribute("model");
        Object req = request.getAttribute("request");


        retMap.put("map", map);
        retMap.put("model", model);
        retMap.put("req", req);

        return retMap;
    }





}
