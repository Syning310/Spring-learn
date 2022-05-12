package com.syning.config;


import com.syning.converter.NingMessageConverter;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.accept.HeaderContentNegotiationStrategy;
import org.springframework.web.accept.ParameterContentNegotiationStrategy;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Configuration(proxyBeanMethods = false)
public class MessageConverterConfig implements WebMvcConfigurer {

    // 配置自定义消息转换器
    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.add(new NingMessageConverter());
    }

    // 配置内容协商策略    format=ning   -->  sy-ning
    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
        // Map<String, MediaType> mediaTypes
        Map<String, MediaType> mediaTypes = new HashMap<>();
        mediaTypes.put("json", MediaType.APPLICATION_JSON);
        mediaTypes.put("xml", MediaType.APPLICATION_XML);
        mediaTypes.put("ning", MediaType.parseMediaType("application/sy-ning"));

        // 指定支持解析哪些请求参数对应哪些媒体类型
        ParameterContentNegotiationStrategy parameterStrategy = new ParameterContentNegotiationStrategy(mediaTypes);

        // 指定请求头的策略
        HeaderContentNegotiationStrategy headerStrategy = new HeaderContentNegotiationStrategy();

        configurer.strategies(Arrays.asList(parameterStrategy, headerStrategy));
    }
}
