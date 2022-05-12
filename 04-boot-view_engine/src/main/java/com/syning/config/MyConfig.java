package com.syning.config;

import com.syning.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration(proxyBeanMethods = false)
public class MyConfig implements WebMvcConfigurer {

    /**
     *
     *  1、编写拦截器，实现 HandleInterceptor 接口
     *  2、拦截器注册到容器中 (实现WebMvcConfigurer的addInterceptors)
     *  3、指定拦截规则，如果是拦截所有，静态资源也会被拦截，但是静态资源访问有前缀时，就不会被拦截  /res/**
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/res/**", "/", "/login");   // 排除静态资源请求，和登录页面请求
    }
}
