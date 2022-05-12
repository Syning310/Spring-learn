package com.syning.interceptor;


import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@Slf4j
/**
 * 登录检查拦截器
 *
 * 1、配置好拦截器要拦截哪些请求
 * 2、把拦截器注册到容器中
 */
public class LoginInterceptor implements HandlerInterceptor {

    //控制器方法之前
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        //log.info("拦截的请求有： " + request.getRequestURI());

        //登录检查逻辑
        HttpSession session = request.getSession();

        Object user = session.getAttribute("user");

        // 如果会话作用域中存在用户，说明已经登录，则可以放行
        if (user != null) {
            // 放行
            return true;
        }

        // 拦截，未登录，跳转到登陆页面
        request.setAttribute("msg", "请先登录");
        request.getRequestDispatcher("/").forward(request, response);
        return false;
    }

    //控制器方法之后，页面渲染之前
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    //页面渲染之后
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
