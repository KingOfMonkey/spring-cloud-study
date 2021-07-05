package com.meiya.springcloudstudy.service1.feign.hystrix;

import com.meiya.springcloudstudy.service1.feign.Service1FeignClient;
import org.springframework.stereotype.Component;

@Component
public class Service1FeignHystrix implements Service1FeignClient {

    @Override
    public String callService(String param) {
        return "the method index of service name : service2 is not available, please try later!";
    }
}
