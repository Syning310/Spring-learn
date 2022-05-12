package com.syning.entity;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data

@Component
@ConfigurationProperties(prefix = "pet")
public class Pet {

    private String name;

    private Double weight;

}
