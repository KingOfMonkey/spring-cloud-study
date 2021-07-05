package com.meiya.springcloudstudy.service1.feign.factory;

import com.meiya.springcloudstudy.service1.feign.Service1FeignClient;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
public class Service1FeignFallbackFactory implements FallbackFactory<Service1FeignClient> {

    @Override
    public Service1FeignClient create(Throwable throwable) {
        return new Service1FeignClient() {
            @Override
            public String callService(String param) {
                return "Service2服务出现故障:" + throwable;
            }
        };
    }
}
