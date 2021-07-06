package com.meiya.springcloudstudy.system;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//需要手动添加扫描common下的类
@ComponentScan(basePackages = {"com.meiya.springcloudstudy.system.*", "com.meiya.springcloudstudy.common.*"})
public class SpringSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringSystemApplication.class);
    }
}

