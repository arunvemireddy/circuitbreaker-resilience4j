package com.example.CustomConfigurer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;


@SpringBootApplication(scanBasePackages = {"com.example"})
@EnableEurekaServer
public class CustomConfigurerApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomConfigurerApplication.class, args);
	}

}
