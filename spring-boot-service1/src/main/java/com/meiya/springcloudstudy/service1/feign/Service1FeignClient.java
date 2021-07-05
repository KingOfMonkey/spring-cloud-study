package com.meiya.springcloudstudy.service1.feign;

import com.meiya.springcloudstudy.service1.feign.factory.Service1FeignFallbackFactory;
import com.meiya.springcloudstudy.service1.feign.hystrix.Service1FeignHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

//@FeignClient(name = "service2", fallback = Service1FeignHystrix.class) //简单返回降级后的信息
@FeignClient(name = "service2", fallbackFactory = Service1FeignFallbackFactory.class) //返回降级后的信息+降级原因
public interface Service1FeignClient {

    /**
     *
     * @param param 参数 注意：此处需要加@RequestParam 负责会报错
     *              error":"Method Not Allowed","message":"Request method 'POST' not supported"
     *              并且 @RequestParam 中的 'name' 要和 service2中接口的 'name'保持一致
     * @return 接口的返回值
     */
    @RequestMapping(method = RequestMethod.GET, value = "/index")
    String callService(@RequestParam(value = "name") String param);
}
