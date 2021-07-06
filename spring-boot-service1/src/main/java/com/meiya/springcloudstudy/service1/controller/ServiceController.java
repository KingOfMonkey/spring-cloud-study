package com.meiya.springcloudstudy.service1.controller;

import com.meiya.springcloudstudy.service1.feign.Service1FeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServiceController {

    @Autowired
    private Service1FeignClient feignClient;

    @RequestMapping(value = "/feign", method = RequestMethod.GET)
    public String index(@RequestParam String name){
        String s = feignClient.callService(name);
        return s;
    }
}
