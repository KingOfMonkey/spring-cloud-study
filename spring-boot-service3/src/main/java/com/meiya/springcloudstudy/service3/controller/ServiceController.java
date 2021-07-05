package com.meiya.springcloudstudy.service3.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServiceController {

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index(@RequestParam String name){
        String message = String.format("你好:%s, 这里是service3为你服务！", name);
        return message;
    }
}
