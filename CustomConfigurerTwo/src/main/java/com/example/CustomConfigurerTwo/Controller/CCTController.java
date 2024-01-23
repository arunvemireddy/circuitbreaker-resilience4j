package com.example.CustomConfigurerTwo.Controller;

import com.example.CustomConfigurerTwo.constants.DBConfig;
import com.example.CustomConfigurerTwo.constants.MobileConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author arun vemireddy
 */
@RestController
@RequestMapping("/client-two")
public class CCTController {
    @Autowired
    private DBConfig dbConfig;
    @Autowired
    private MobileConfig mobileConfig;

    @GetMapping("/pcConfig")
    public ResponseEntity<Map<String, String>> pcConfig() {
        Map<String, String> pcModels = new HashMap<>();
        pcModels.put("HP", "Z1");
        pcModels.put("Apple", "M2");
        return ResponseEntity.ok(pcModels);
    }

    @GetMapping(path = "/mobileConfig")
    public ResponseEntity<?> mobileConfig() {
        Map<String, String[]> mobileModel = new HashMap<>();
        mobileModel.put(mobileConfig.brandOne, new String[]{"S6", "S7", "Galaxy"});
        mobileModel.put(mobileConfig.brandTwo, new String[]{"K3", "K4", "K5"});
        mobileModel.put(mobileConfig.brandThree, new String[]{"X", "11", "12"});
        return ResponseEntity.ok(mobileModel);
    }

    @GetMapping(path = "/dbConfig")
    public ResponseEntity<?> dbConfig() {
        Map<String, String> dbConfigurations = new HashMap<>();
        dbConfigurations.put("name", dbConfig.dbName);
        dbConfigurations.put("engine", dbConfig.dbEngine);
        dbConfigurations.put("url", dbConfig.url);
        dbConfigurations.put("username", dbConfig.username);
        dbConfigurations.put("password", dbConfig.password);
        dbConfigurations.put("driverClassName", dbConfig.driverClassName);
        return new ResponseEntity<>(dbConfigurations, HttpStatus.OK);
    }
}
