package com.syning.boot.boot05web03.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;
import java.util.Arrays;

@Deprecated
//@Configuration
public class MyDataSourceConfig {

    // 默认的自动配置是判断容器中没有数据源才会配置 HikariDataSource 的数据源
    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean
    public DataSource dataSource() {
        DruidDataSource druidDataSource = new DruidDataSource();

//        try {
//            // 加入监控功能
//            druidDataSource.setFilters("stat,wall");
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }

        return druidDataSource;
    }


    /**
     *  配置 druid 的监控页功能
     * @return
     */
    @Bean
    public ServletRegistrationBean statViewServlet() {
        StatViewServlet statViewServlet = new StatViewServlet();
        ServletRegistrationBean<StatViewServlet> servletRegistrationBean
                = new ServletRegistrationBean(statViewServlet, "/druid/*");

        servletRegistrationBean.addInitParameter("loginUsername", "syning");
        servletRegistrationBean.addInitParameter("loginPassword", "0310");

        return servletRegistrationBean;
    }


    /**
     *  WebStatFilter 用户采集 web-jdbc 关联监控的数据
     */
    public FilterRegistrationBean webStatFilter() {

        WebStatFilter webStatFilter = new WebStatFilter();

        FilterRegistrationBean<WebStatFilter> filterRegistrationBean
                = new FilterRegistrationBean<>(webStatFilter);

        // 设置拦截的请求映射
        filterRegistrationBean.setUrlPatterns(Arrays.asList("/*"));

        // 排除访问静态资源的请求 和 /druid
        filterRegistrationBean.addInitParameter("exclusions", "*.js,*.gif,*.png,*.css,*.ico,/druid/*");

        return filterRegistrationBean;
    }




}
