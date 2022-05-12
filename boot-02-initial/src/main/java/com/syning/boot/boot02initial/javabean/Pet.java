package com.syning.boot.boot02initial.javabean;

public class Pet {

    private String name;
    private Double weight;

    @Override
    public String toString() {
        return "Pet{" +
                "name='" + name + '\'' +
                ", weight=" + weight +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Pet(String name, Double weight) {
        this.name = name;
        this.weight = weight;
    }

    public Pet() {
    }
}
