package com.syning.filter;


import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpRequest;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;


@Slf4j
/**
 *  拦截所有的静态资源请求
 *  注意： /*  是 Servlet 的写法； /** 是 spring 的写法
 */
//@WebFilter(urlPatterns = {"/res/*"})
public class MyFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("MyFilter 初始化完成");
    }
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        log.info("MyFilter 工作");
        filterChain.doFilter(servletRequest, servletResponse);
    }
    @Override
    public void destroy() {
        log.info("MyFilter 销毁了");
    }
}
