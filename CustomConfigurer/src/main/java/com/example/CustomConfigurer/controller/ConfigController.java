package com.example.CustomConfigurer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author arun vemireddy
 */
@RestController
@RequestMapping(path = "/eureka")
public class ConfigController {

    @Autowired
    private Environment environment;

    @GetMapping
    public ResponseEntity<?>  eureka(){
        return new ResponseEntity<>("Eureka Server is Up",HttpStatus.OK);
    }

    @RequestMapping(path = "/env")
    public ResponseEntity<?> env(){
        return new ResponseEntity<>(environment.getActiveProfiles(),HttpStatus.OK);
    }

}
