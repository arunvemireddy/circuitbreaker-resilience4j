package com.example.CustomConfigurerTwo.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author arun vemireddy
 */
@RestController
@RequestMapping("/two")
public class CCTController {

    @GetMapping(path = "/CCTendpoint1")
    public ResponseEntity<?> CCTendpoint1(){
        return new ResponseEntity<>("CCTEP1", HttpStatus.OK);
    }

    @GetMapping(path = "/CCTendpoint2")
    public ResponseEntity<?> CCTendpoint2(){
        return new ResponseEntity<>("CCTEP2", HttpStatus.OK);
    }

    @GetMapping(path = "/CCTendpoint3")
    public ResponseEntity<List<String>> CCTendpoint3(){
        List<String> list=List.of("MicroService","Netflix","Eureka Server","Eureka Client","Client Register","Hystrix");
        return new ResponseEntity<>(list, HttpStatus.OK);
    }


}
