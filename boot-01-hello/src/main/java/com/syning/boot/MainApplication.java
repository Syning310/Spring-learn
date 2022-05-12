package com.syning.boot;


import com.syning.boot.bean.Person;
import com.syning.boot.bean.Pet;
import com.syning.boot.config.MyConfig;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;


/**
 * 主程序类；主配置类
 * 这是一个 SpringBoot 应用
 */

//@SpringBootApplication  // 这一个注解可以取带以下三个注解，默认扫描这个主配置类所在的包，以及它的子包

@SpringBootConfiguration  // 代表当前是一个配置类
@EnableAutoConfiguration  // 自动配置包，指定了默认的包规则
@ComponentScan("com.syning.boot")   // 指定扫描哪些包
public class MainApplication {


    public static void main(String[] args) {
        // 1、返回 IOC 容器
        ConfigurableApplicationContext run = SpringApplication.run(MainApplication.class, args);

        // 2、查看容器中的组件
        String[] names = run.getBeanDefinitionNames();

        for (String name : names) {
            System.out.println(name);
        }

        System.out.println("=========== 从容器中获取组件 ===========");
        // 3、从容器中获取组件
        Pet pet1 = run.getBean("pet", Pet.class);
        Pet pet2 = run.getBean("pet", Pet.class);
        // 判断两个组件是不是同一个
        System.out.println("pet1 = " + pet1 + ", hash = " + pet1.hashCode());
        System.out.println("pet2 = " + pet2 + ", hash = " + pet2.hashCode());



        // 4、获取配置类组件 : com.syning.boot.config.MyConfig$$EnhancerBySpringCGLIB$$97cd7be7@5c089b2f
        // 这是一个被增强的代理对象
        MyConfig myConfig = run.getBean(MyConfig.class);

        System.out.println(myConfig);

        // 调用配置类的 @Bean 注解的方法
        // SpringBoot总会检查这个组件是否在容器中已有实例，如果有则返回容器中的对象；保持组件的单实例
        Person person1 = myConfig.person01();
        Person person2 = myConfig.person01();
        Person person3 = myConfig.person01();

        System.out.println("person1.hash = " + person1.hashCode());
        System.out.println("person2.hash = " + person2.hashCode());
        System.out.println("person3.hash = " + person3.hashCode());



        // 5、查看 Person 对象实例中的 Pet
        System.out.println("=========== 查看 Person 对象实例中的 Pet ===========");
        System.out.println(person1);

        System.out.println("person1.getPet() == pet1 ? " + (person1.getPet() == pet1));



        // 6、验证 @Import
        String[] beanNamesForType = run.getBeanNamesForType(Person.class);
        System.out.println("=========== 所有 Person.class 类型的组件名 ===========");
        for (String b : beanNamesForType) {
            System.out.println(b);
        }



        // 7、@Conditional
        System.out.println("=========== @Conditional 注解 ===========");
        boolean ping = run.containsBean("ping");
        System.out.println("容器中是否存在 ping 组件 =  " + ping);

        boolean bpet = run.containsBean("pet");
        System.out.println("容器中是否存在 pet 组件 = " + bpet);



    }


}
