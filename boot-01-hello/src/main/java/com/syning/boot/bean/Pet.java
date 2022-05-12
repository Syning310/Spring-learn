package com.syning.boot.bean;

public class Pet {

    private String name;
    private Integer age;

    public Pet() {}

    @Override
    public String toString() {
        return "Pet{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Pet(String name, Integer age) {
        this.name = name;
        this.age = age;
    }
}
