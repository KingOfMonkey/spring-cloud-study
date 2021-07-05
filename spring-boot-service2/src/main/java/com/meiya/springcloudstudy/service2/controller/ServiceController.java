package com.meiya.springcloudstudy.service2.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServiceController {

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index(@RequestParam String name){
        System.out.println(1/0);
        String message = String.format("你好:%s, 这里是service2为你服务！", name);
        return message;
    }
}
