package com.syning.boot.boot03web01.controller;


import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ParameterController {

    @GetMapping("/car/{id}/owner/{username}")
    public Map<String, Object> getCar(@PathVariable("id") Integer id,
                                      @PathVariable("username") String username,
                                      @PathVariable Map<String, String> pv,
                                      @RequestHeader("User-Agent") String userAgent,
                                      @RequestHeader Map<String, String> headersMap) {
        Map<String, Object> map = new HashMap<>();
        map.put("id", id);
        map.put("username", username);
        map.put("pv", pv);


        map.put("userAgent", userAgent);
        map.put("headersMap", headersMap);


        return map;
    }



    @GetMapping("/getparam")
    public Map<String, Object> getParam(@RequestParam("age") Integer age,
                                        @RequestParam("inters") List<String> inters,
                                        @RequestParam Map<String, String> paramsMap) {
        Map<String, Object> map = new HashMap<>();
        map.put("age", age);
        map.put("inters", inters);
        map.put("paramsMap", paramsMap);


        return map;
    }


    @PostMapping("/save")
    public Map<String, Object> postMethod(@RequestBody String content) {
        Map<String, Object> map = new HashMap<>();

        map.put("content", content);

        return map;
    }




}
