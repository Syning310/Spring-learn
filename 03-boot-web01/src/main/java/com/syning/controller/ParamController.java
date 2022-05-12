package com.syning.controller;


import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import java.util.HashMap;
import java.util.Map;

@RestController
public class ParamController {


    @GetMapping("/like")
    public Map<String, Object> getParam(@CookieValue("Idea-a53e0d51") String ifed,
                                        @CookieValue Cookie cookie) {
        Map<String, Object> map = new HashMap<>();

        map.put("cook", ifed);
        map.put("cookie", cookie);

        return map;
    }



    @PostMapping("/save")
    public Map<String, Object> getBody(@RequestBody String content) {
        Map<String, Object> map = new HashMap<>();

        map.put("content", content);
        return map;
    }





}
