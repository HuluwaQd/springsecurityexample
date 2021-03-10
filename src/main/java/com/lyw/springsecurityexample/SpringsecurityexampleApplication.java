package com.lyw.springsecurityexample;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.lyw.springsecurityexample.mapper")
public class SpringsecurityexampleApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringsecurityexampleApplication.class, args);
    }

}
