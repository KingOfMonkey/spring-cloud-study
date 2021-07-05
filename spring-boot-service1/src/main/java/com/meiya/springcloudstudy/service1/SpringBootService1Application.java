package com.meiya.springcloudstudy.service1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class SpringBootService1Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootService1Application.class);
    }
}
