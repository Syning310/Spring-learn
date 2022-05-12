package com.syning.config;


import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class MyDruidDataSource {
    /**
     *   @ConditionalOnMissingBean({DataSource.class})
     *   默认配置是：当容器中没有 DataSource 类，才会配置数据源
     *   当我们 @Bean DataSource 时，容器中就有了数据源，自动配置就不会装配数据源了
     *
     *   使用 @ConfigurationProperties 绑定配置文件的配置信息
     */
    @Bean(value = "dataSource")
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource dataSource() {
        DruidDataSource druidDataSource = new DruidDataSource();
        return druidDataSource;
    }


    /**
     *  配置 druid 的监控页功能
     */
    @Bean
    public ServletRegistrationBean statViewServlet() {
        StatViewServlet statViewServlet = new StatViewServlet();
        ServletRegistrationBean<StatViewServlet> servletRegistrationBean
                = new ServletRegistrationBean<>(statViewServlet, "/druid/*");
        return servletRegistrationBean;
    }


}
