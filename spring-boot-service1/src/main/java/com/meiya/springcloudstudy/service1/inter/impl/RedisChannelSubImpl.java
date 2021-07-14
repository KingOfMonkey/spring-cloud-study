package com.meiya.springcloudstudy.service1.inter.impl;

import com.meiya.springcloudstudy.service1.inter.RedisMsgInterface;
import org.springframework.stereotype.Component;

@Component
public class RedisChannelSubImpl implements RedisMsgInterface {

    @Override
    public void handleMessage(String message) {
        System.out.println("message = " + message);
    }
}
