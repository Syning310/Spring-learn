package com.syning.entity;

public class Pet {

    private String name;

    public Pet() {}

    @Override
    public String toString() {
        return "Pet{" +
                "name='" + name + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Pet(String name) {
        this.name = name;
    }
}
