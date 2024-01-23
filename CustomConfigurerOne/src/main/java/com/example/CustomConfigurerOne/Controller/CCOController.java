package com.example.CustomConfigurerOne.Controller;



import com.example.CustomConfigurerOne.constants.ConfigOneConstants;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.RetryConfig;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.Response;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import reactor.core.publisher.Mono;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author arun vemireddy
 */
@RestController
@RequestMapping(path = "/client-one")
@Slf4j
public class CCOController {

    @Autowired
    private RestTemplate restTemplate;


    private static final String RESILIENCE4J_INSTANCE_NAME = "example";

    @Bean
    public RetryConfig pcConfigRetryConfig() {
        return RetryConfig.custom()
                .maxAttempts(3)  // Adjust as needed
                .waitDuration(Duration.ofMillis(5000))  // Adjust as needed
                .retryExceptions(IOException.class)  // Specify relevant exceptions
                .build();
    }


    @GetMapping(path = "/osConfig")
    public ResponseEntity<Map<String,String>> osConfig(){
        Map<String,String> osVersions = new HashMap<>();
        osVersions.put("Windows","11");
        osVersions.put("Linux","Ubuntu");
        osVersions.put("macOs","Sonoma");
        return ResponseEntity.ok(osVersions);
    }

    @GetMapping(path = "/pcConfig")
    @CircuitBreaker(name = "pc",fallbackMethod = "pcFail")
    @Retry(name = "pcConfigRetryConfig")
    public ResponseEntity<?> pcConfig(){
        return new ResponseEntity<>(restTemplate.getForObject(ConfigOneConstants.config_two_base_url +"pcConfig", Map.class), HttpStatus.OK);
    }

    public ResponseEntity<?> pcFail(Throwable throwable){
        log.info("Fallback method pcFail() called");
        return new ResponseEntity<>("PC service is down. Try after sometime", HttpStatus.OK);
    }

    @GetMapping(path = "/mobileConfig")
    @CircuitBreaker(name = "mobile",fallbackMethod = "mobileFail")
    public ResponseEntity<?> mobileConfig(){
        return new ResponseEntity<>(restTemplate.getForObject(ConfigOneConstants.config_two_base_url +"mobileConfig", Map.class), HttpStatus.OK);
    }

    public ResponseEntity<?> mobileFail(Throwable throwable){
        return ResponseEntity.ok("Mobile service is down. Try after sometime");
    }

    @GetMapping(path = "/dbConfig")
    @CircuitBreaker(name = "db",fallbackMethod = "dbFail")
    public ResponseEntity<?> dbConfig(){
        return new ResponseEntity<>(restTemplate.getForObject(ConfigOneConstants.config_two_base_url +"dbConfig", Map.class), HttpStatus.OK);
    }

    public ResponseEntity<?> dbFail(Throwable throwable){
        return ResponseEntity.ok("DB service is down. Try after sometime");
    }
}
