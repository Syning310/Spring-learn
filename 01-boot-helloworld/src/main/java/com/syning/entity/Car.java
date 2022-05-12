package com.syning.entity;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 *  需要添加 @Component 注解，将对象放入容器中
 *  只有在容器中的组件，才会拥有springboot提供的功能
 */
//@Component
@ConfigurationProperties(prefix = "mycar")
public class Car {

    private String brand;

    private Integer price;

    public Car() {}

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", price=" + price +
                '}';
    }
}
