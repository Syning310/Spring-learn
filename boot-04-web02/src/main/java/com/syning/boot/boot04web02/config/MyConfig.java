package com.syning.boot.boot04web02.config;

import com.syning.boot.boot04web02.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


/**
 *
 *  1、编写拦截器，实现 HandleInterceptor 接口
 *  2、拦截器注册到容器中 (实现WebMvcConfigurer的addInterceptors)
 *  3、指定拦截规则，如果是拦截所有，静态资源也会被拦截
 */

@Configuration
public class MyConfig implements WebMvcConfigurer {


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns("/**")   // 默认拦截所有的请求
                .excludePathPatterns("/", "/login", "/css/**", "/fonts/**", "/images/**", "/js/**");   // 排除这两个请求
    }
}
