package com.example.CustomConfigurerTwo.constants;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
@ConfigurationProperties(prefix = "mobile")
public class MobileConfig {

    public String brandOne;
    public String brandTwo;
    public String brandThree;

    public String getBrandOne() {
        return brandOne;
    }

    public void setBrandOne(String brandOne) {
        this.brandOne = brandOne;
    }

    public String getBrandTwo() {
        return brandTwo;
    }

    public void setBrandTwo(String brandTwo) {
        this.brandTwo = brandTwo;
    }

    public String getBrandThree() {
        return brandThree;
    }

    public void setBrandThree(String brandThree) {
        this.brandThree = brandThree;
    }
}
