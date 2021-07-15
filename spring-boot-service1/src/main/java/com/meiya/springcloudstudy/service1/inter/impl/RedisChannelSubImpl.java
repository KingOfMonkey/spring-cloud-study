package com.meiya.springcloudstudy.service1.inter.impl;

import com.meiya.springcloudstudy.service1.inter.RedisMsgInterface;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RedisChannelSubImpl implements RedisMsgInterface {

    private static Logger logger = LoggerFactory.getLogger(RedisChannelSubImpl.class);

    @Override
    public void handleMessage(String message) {
        logger.info("handleMessage = {}", message);
    }

    @Override
    public void receiveMsg(String message) {
        logger.info("receiveMsg = {}", message);
    }
}
