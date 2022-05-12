package com.syning.boot.boot04web02.interceptor;


import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *  登录检查拦截器
 *
 *  1、配置好拦截器要拦截哪些请求
 *  2、把拦截器放在容器中
 */


public class LoginInterceptor implements HandlerInterceptor {

    // 控制器方法执行之前
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        //System.out.println("拦截的请求路径是 = " + request.getRequestURI());

        // 登录检查逻辑
        HttpSession session = request.getSession();

        Object currentUser = session.getAttribute("currentUser");

        if (currentUser != null) {
            // 放行
            return true;
        }


        // 拦截，未登录，跳转到登陆页面
        request.setAttribute("msg", "请先登录");

        request.getRequestDispatcher("/").forward(request, response);

        return false;
    }

    // 控制器方法执行后，页面渲染之前
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    // 页面渲染之后
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
