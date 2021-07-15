package com.meiya.springcloudstudy.service1.config;

import com.meiya.springcloudstudy.service1.inter.RedisMsgInterface;
import com.meiya.springcloudstudy.service1.inter.impl.RedisChannelSubImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.listener.PatternTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;

/**
 * Redis channel 订阅发布配置类
 */
@Configuration
public class RedisChanelConfig {

    private static final String CHANNEL_NAME = "case_channel";

    @Bean
    public RedisMessageListenerContainer container(RedisConnectionFactory redisConnectionFactory){
        RedisMessageListenerContainer container = new RedisMessageListenerContainer();
        container.setConnectionFactory(redisConnectionFactory);
        //可以添加多个监听器
        container.addMessageListener(listenerAdapter(new RedisChannelSubImpl()), new PatternTopic(CHANNEL_NAME));
        container.addMessageListener(listenerAdapter2(new RedisChannelSubImpl()), new PatternTopic(CHANNEL_NAME));
        return container;
    }

    @Bean
    public MessageListenerAdapter listenerAdapter(RedisMsgInterface redisMsgInterface){
        return new MessageListenerAdapter(redisMsgInterface);
    }

    @Bean
    public MessageListenerAdapter listenerAdapter2(RedisMsgInterface redisMsgInterface){
        return new MessageListenerAdapter(redisMsgInterface, "receiveMsg");
    }
}
