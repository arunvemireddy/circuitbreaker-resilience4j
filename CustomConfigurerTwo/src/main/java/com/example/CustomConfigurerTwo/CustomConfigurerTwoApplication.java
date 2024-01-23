package com.example.CustomConfigurerTwo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;


@SpringBootApplication(scanBasePackages = {"com.example"})
@EnableDiscoveryClient
@EnableHystrix
public class CustomConfigurerTwoApplication {
    public static void main(String[] args) {
        SpringApplication.run(CustomConfigurerTwoApplication.class, args);
    }

}
