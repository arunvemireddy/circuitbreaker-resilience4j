package com.example.CustomConfigurer;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author arun vemireddy
 */

@Configuration
@ConfigurationProperties("db")
public class DBConfigurer {

    @Value("19")
    private int num;

    @Value("${num2}")
    private int num2;
    private int port;
    private String applicationname;

    public int getNum2() {
        return num2;
    }

    public void setNum2(int num2) {
        this.num2 = num2;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getApplicationname() {
        return applicationname;
    }

    public void setApplicationname(String applicationname) {
        this.applicationname = applicationname;
    }
}
