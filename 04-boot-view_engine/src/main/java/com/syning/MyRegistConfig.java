package com.syning;


import com.syning.filter.MyFilter;
import com.syning.listener.MyServletContextListener;
import com.syning.servlet.Myservlet;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class MyRegistConfig {

    @Bean
    public ServletRegistrationBean myServlet() {
        Myservlet myServlet = new Myservlet();
        return new ServletRegistrationBean(myServlet, "/myst", "/my00");
    }

    /**
     *  FilterRegistrationBean(myFilter, myServlet());
     *  第一个参数注册过滤器，第二个参数是Servlet注册器接收什么请求，过滤器注册器就过滤什么请求
     */
    @Bean
    public FilterRegistrationBean myFilter() {
        MyFilter myFilter = new MyFilter();
        FilterRegistrationBean filterRegistration = new FilterRegistrationBean(myFilter, myServlet());
        filterRegistration.setUrlPatterns(Arrays.asList("/res/*"));
        return filterRegistration;
    }

    @Bean
    public ServletListenerRegistrationBean myListener() {
        MyServletContextListener myServletContextListener = new MyServletContextListener();
        return new ServletListenerRegistrationBean(myServletContextListener);
    }
}
