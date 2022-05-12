package com.syning.controller;

import com.syning.entity.User;
import com.syning.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/login")
    public String login(User user, HttpSession session) {

        if (user == null || "".equals(user.getName()) || "".equals(user.getPwd())) {
            throw new NullPointerException("请输入账号密码");
        }

        // 从数据库中获取数据
        User currentUser = userService.loginByNamePwd(user.getName(), user.getPwd());

        // 如果没有从数据库中取出数据，跳转错误页面
        if (currentUser == null) {
            throw new NullPointerException("账号或密码错误");
        } else {

            // 如果取得数据，那么把数据放入 session 作用域中
            session.setAttribute("currentUser", currentUser);
            return "redirect:/message";
        }
    }




    @GetMapping("/exit")
    public String exit(HttpSession session) {

        // 将当前登录用户置为空
        session.setAttribute("currentUser", null);

        return "redirect:/";
    }


}
