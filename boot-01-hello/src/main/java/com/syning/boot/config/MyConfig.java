package com.syning.boot.config;


import com.syning.boot.bean.Car;
import com.syning.boot.bean.Person;
import com.syning.boot.bean.Pet;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


// 13、开启 Car 属性配置功能，并且将这个类创建的组件，注册到 spring 容器中
@EnableConfigurationProperties({Car.class})

// 12、引入原生配置文件
// @ImportResource("classpath:beans.xml")



// 11、这个注解的意思是 - 当容器中没有 ping 这个组件的时候，才会执行以下配置类
@ConditionalOnMissingBean(name = "ping")



// 1、@Configuration 告诉 SpringBoot 这是一个配置类 = spring 配置文件
// 2、标注的配置类本身也是一个组件
// 6、proxyBeanMethods 增强 @Bean 的方法
@Configuration(proxyBeanMethods = true)   // 8、SpringBoot总会检查这个组件是否在容器中已有实例，如果有则返回容器中的对象；保持组件的单实例
public class MyConfig {


    // 9、Full模式(proxyBeanMethods = true)
    // 10、Lite模式(proxyBeanMethods = false)

    // 5、依然与 Spring5 特性一样，创建出来的对象默认是单实例的
    // 7、外部无论对配置类中的这个组件 @Bean 注册方法调用多少次，获取的都是注册在容器中的单实例对象


    @Bean  // 3、给容器中添加组件，以方法名作为组件的 id(key) 返回类型就是组件类型(Person)
    public Person person01() {
        Person person = new Person("宁", 28);
        person.setPet(pet01());   // 组件依赖
        return person;  // 返回的实例会交给容器进行管理
    }



    @Bean(value = {"pet"})  // 4、如果给 Bean 注解的 value 属性赋值，那么在组件中的 id 就是以 value 值为 key
    public Pet pet01() {
        return new Pet("小白", 4000);
    }




}
