package com.syning;


import ch.qos.logback.classic.db.names.SimpleDBNameResolver;
import com.syning.config.MyConfig;
import com.syning.controller.HelloController;
import com.syning.entity.Person;
import com.syning.entity.Pet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;


// 3、添加主程序类，告诉 SpringBoot 这是一个 SpringBoot 应用
@SpringBootApplication
public class MainApplication {

    public static void main(String[] args) {

        // 返回 IOC 容器
        ConfigurableApplicationContext context = SpringApplication.run(MainApplication.class, args);





//        boolean yanExists = context.containsBean("yan");
//        System.out.println("容器中有没有 yan 组件 = " + yanExists);
//        boolean treeExiste = context.containsBean("tree");
//        System.out.println("容器中有没有 tree 组件 = " + treeExiste);


//        // 查看容器中有无组件
//        boolean ningExists = context.containsBean("ning");
//        System.out.println("容器中有没有 ning 组件 = " + ningExists);  // false
//        boolean controllerExists = context.containsBean("hello");
//        System.out.println("HelloController是否存在容器中 = " + controllerExists);  // false
//
//        // 容器中是否有 MyConfig
//        boolean myConfigExists = context.containsBean("myConfig");
//        System.out.println("myConfig是否存在容器中 = " + myConfigExists);

//        // 从容器中获取组件
//        String[] pNames = context.getBeanNamesForType(Person.class);
//        for (String name : pNames) {
//            System.out.println(name);   // person1 和 com.syning.entity.Person
//        }
//        String[] sNames = context.getBeanNamesForType(SimpleDBNameResolver.class);
//        for (String name : sNames) {
//            System.out.println(name);  // ch.qos.logback.classic.db.names.SimpleDBNameResolver
//        }

//
//        // 2、查看容器中的组件
//        String[] names = context.getBeanDefinitionNames();
//        for (String name : names) {
//            System.out.println(name);
//        }
//
//        // 3、从容器中获取组件
//        Pet p1 = context.getBean("xiaobai", Pet.class);
//        Pet p2 = context.getBean("xiaobai", Pet.class);
//        System.out.println("组件是否是同一个 = " + (p1 == p2));
//
//        // 4、配置类也是组件，也在 IOC 容器中
//        MyConfig myConfig = context.getBean(MyConfig.class);
//        System.out.println(myConfig);
//
//        // 5、如果 @Configuration(proxyBeanMethods = true)
//        // 代理对象调用方法，springboot总会检查这个组件是否存在容器中，如果存在容器中则从容器中返回，则不会创建新对象(保持组件单实例)
//        Person person1 = myConfig.person1();
//        Person person2 = myConfig.person1();
//        System.out.println("person1 == person2 ? " + (person1 == person2));

    }

}
