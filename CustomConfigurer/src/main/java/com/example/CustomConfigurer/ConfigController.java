package com.example.CustomConfigurer;

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
@RequestMapping("/")
public class ConfigController {

    @Autowired
    private Environment environment;

    @Autowired
    private DBConfigurer dbConfigurer;

    @GetMapping("/getconfig")
    public ResponseEntity<String> getConfig(){
        String details=dbConfigurer.getPort()+""+dbConfigurer.getApplicationname()+""+dbConfigurer.getNum()+""+dbConfigurer.getNum2();
        return new ResponseEntity<>(details, HttpStatus.OK);
    }

    @RequestMapping(path = "/env")
    public ResponseEntity<?> env(){
        return new ResponseEntity<>(environment.getActiveProfiles(),HttpStatus.OK);
    }

}
