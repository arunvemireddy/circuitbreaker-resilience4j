package com.example.CustomConfigurerTwo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class CustomConfigurerTwoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomConfigurerTwoApplication.class, args);
	}

}
