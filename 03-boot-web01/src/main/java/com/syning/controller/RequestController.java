package com.syning.controller;


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

    @GetMapping("/tosuccess")
    public String gotoMethod(HttpServletRequest request) {

        request.setAttribute("message", "保存成功...");
        return "forward:/success";
    }

    @ResponseBody
    @GetMapping("/success")
    public String toSuccess(@RequestAttribute("message") String message) {
        System.out.println(message);
        return "success";
    }




    @ResponseBody
    // <a href="/cars/sell;low=34;brand=byd"> /cars/sell;low=34;brand=byd </a>
    @GetMapping("/cars/{path}")
    public Map carsSell(@MatrixVariable(value = "low", pathVar = "path") Integer low,
                        @MatrixVariable(value = "brand", pathVar = "path") List<String> brands,
                        @PathVariable("path") String path) {
        Map<String, Object> map = new HashMap<>();

        map.put("low", low);
        map.put("brands", brands);
        map.put("path", path);

        return map;
    }



    @ResponseBody
    // <a href="/mywife/person;name=ning;age=13000/wife;name=hongyan;name=yaoji;age=28">
    @GetMapping("/mywife/{person}/{wife}")
    public Map mywife(@MatrixVariable(pathVar = "person", value = "name") String myName,
                      @MatrixVariable(pathVar = "person", value = "age") Integer myAge,
                      @MatrixVariable(pathVar = "wife", value = "name") List<String> wfNames,
                      @MatrixVariable(pathVar = "wife", value = "age") Integer wfAge) {
        Map<String, Object> map = new HashMap<>();

        map.put("myName", myName);
        map.put("myAge", myAge);
        map.put("wfNames", wfNames);
        map.put("wfAge", wfAge);

        return map;
    }




    @ResponseBody
    @GetMapping("/params")
    public String testParam(Map<String, Object> map,
                            Model model,
                            HttpServletRequest request,
                            HttpServletResponse response) {


        return "params";
    }



}
