package com.syning.config;

import com.syning.entity.Car;
import com.syning.entity.Person;
import com.syning.entity.Pet;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



//@ConditionalOnBean(name = "tom")


// 配置类中使用 @Bean 标注在方法上给容器注册组件，默认是单实例的
// 告诉 SpringBoot 这是一个配置类，等同于配置文件，配置类也是一个组件
@Configuration(proxyBeanMethods = true, value = "myConfig")  // proxyBeanMethods 代理 bean 的方法

@EnableConfigurationProperties(value = Car.class)
public class MyConfig {

    // 给容器中添加组件，以方法名作为组件的 id，返回类型就是组件的类型，返回的值就是组件在容器中的实例
    @Bean(name = "ning")
    public Person person1() {
        Person person = new Person("宁", 130000);
        // person 组件，依赖了 pet 组件
        person.setPet(pet1());
        return person;
    }


    @Bean(value = "xiaobai")
    public Pet pet1() {
        return new Pet("小白");
    }
}
