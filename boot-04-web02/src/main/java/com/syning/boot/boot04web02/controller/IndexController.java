package com.syning.boot.boot04web02.controller;


import com.syning.boot.boot04web02.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

@Controller
public class IndexController {


    // 前往登陆页面
    @GetMapping(value = {"/", "/login"})
    public String loginPage() {
        return "login";
    }


    // 处理登录请求，登录请求，然后重定向到 main 页面
    @PostMapping("/login")
    public String main(User user, HttpSession session, Model model) {

        // 如果传来的用户有内容，那么登陆成功
        if (StringUtils.hasLength(user.getUsername()) && "".equals(user.getPassword())) {
            // 将用户保存到 session 域中，为当前登录的用户
            session.setAttribute("currentUser", user);
            // 重定向到 /main.html 请求，给客户端 main 页面
            return "redirect:/main.html";
        } else {
            model.addAttribute("msg", "账号或密码错误");
            return "login";
        }
    }


    // 防止在地址栏输入请求直接到 main 页面，需要先判断用户登陆了没有 (在拦截器中进行判断)
    @GetMapping("/main.html")
    public String mainPage(HttpSession session, Model model) {

        return "main";
    }



}
