package com.example.CustomConfigurerOne.Controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

/**
 * @author arun vemireddy
 */
@RestController
@RequestMapping(path = "/one")
public class CCOController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping(path = "/CCOendpoint1")
    public ResponseEntity<?> CCTendpoint1(){
        return new ResponseEntity<>("CCOEP1", HttpStatus.OK);
    }

    @GetMapping(path = "/CCOendpoint2")
    public ResponseEntity<?> CCTendpoint2(){
        return new ResponseEntity<>("CCOEP2", HttpStatus.OK);
    }

    @GetMapping(path = "/CCOendpoint3ms")
    @HystrixCommand(fallbackMethod = "CCTendpoint3msh")
    public ResponseEntity<?> CCTendpoint3ms(){
        List<String> list = new ArrayList();
        list=restTemplate.getForObject("http://secondmicroservice/two/CCTendpoint3", List.class);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    public ResponseEntity<?> CCTendpoint3msh(){

        return new ResponseEntity<>("MS2Down", HttpStatus.OK);
    }
}
