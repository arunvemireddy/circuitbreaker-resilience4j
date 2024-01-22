package com.example.CustomConfigurerOne;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;


@SpringBootApplication(scanBasePackages = {"com.example"})
@EnableHystrix
@EnableDiscoveryClient
public class CustomConfigurerOneApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomConfigurerOneApplication.class, args);
	}

}
