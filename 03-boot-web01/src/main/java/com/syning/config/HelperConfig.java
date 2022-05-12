package com.syning.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.util.UrlPathHelper;

@Configuration(proxyBeanMethods = false)
public class HelperConfig implements WebMvcConfigurer {
    // 第一种方法
    @Override
    public void configurePathMatch(PathMatchConfigurer configurer) {
        UrlPathHelper urlPathHelper = new UrlPathHelper();
        // 设置不截断分号后面的内容，矩阵变量的功能就可以生效
        urlPathHelper.setRemoveSemicolonContent(false);
        configurer.setUrlPathHelper(urlPathHelper);
    }

    // 第二种方法
//    @Bean
//    public WebMvcConfigurer webMvcConfigurer() {
//        return new WebMvcConfigurer() {
//            @Override
//            public void configurePathMatch(PathMatchConfigurer configurer) {
//                UrlPathHelper urlPathHelper = new UrlPathHelper();
//                // 设置不截断分号后面的内容，矩阵变量的功能就可以生效
//                urlPathHelper.setRemoveSemicolonContent(false);
//                configurer.setUrlPathHelper(urlPathHelper);
//            }
//        };
//    }
}
