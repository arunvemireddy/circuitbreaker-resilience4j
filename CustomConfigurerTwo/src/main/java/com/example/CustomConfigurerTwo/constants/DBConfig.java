package com.example.CustomConfigurerTwo.constants;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DBConfig {

    @Value("${db.name}")
    public String dbName;
    @Value("${db.engine}")
    public String dbEngine;
    @Value("${db.url}")
    public String url ="url";
    @Value("${db.username}")
    public String username;
    @Value("${db.password}")
    public String password;
    @Value("${db.driver-class-name}")
    public String driverClassName;

}
