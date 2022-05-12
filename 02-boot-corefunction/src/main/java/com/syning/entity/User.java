package com.syning.entity;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Data

@Component
@ConfigurationProperties(prefix = "user")
public class User {

    private String username;

    private Boolean boos;

    private Date date;

    private Integer age;

    private Pet pet;

    private String[] interests;

    private List<String> animal;

    private Map<String, Object> score;

    private Set<Double> salarys;

    private Map<String, List<Pet>> allPets;
}
