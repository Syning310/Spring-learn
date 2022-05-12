package com.syning.controller;


import com.syning.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;


@Controller
public class ViewController {


    @GetMapping(value = {"/", "/longin"})
    public String loginPage() {

        return "login";
    }


    // 登录成功后，重定向到index页面
    @PostMapping("/login")
    public String index(User user, HttpSession session) {  // RedirectAttributes 重定向携带数据

        if (StringUtils.hasLength(user.getUsername()) && StringUtils.hasLength(user.getPwd())) {

            // 登录成功后，将用户密码封装成 User ，放入 Session 作用域中
            session.setAttribute("user", user);
            return "redirect:/index";
        } else {
            return "redirect:/";
        }
    }


    @GetMapping("/index")
    public String indexPage() {
        return "index";
    }


    // 退出登录，要清除 session 作用域中的用户
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.setAttribute("user", null);
        return "redirect:/";
    }



}
