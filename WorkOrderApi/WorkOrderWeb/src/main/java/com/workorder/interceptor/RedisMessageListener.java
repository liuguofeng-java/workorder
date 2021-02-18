package com.workorder.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.KeyExpirationEventMessageListener;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;

/**
 * 监听redis key 过期
 */
public class RedisMessageListener extends KeyExpirationEventMessageListener {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    public RedisMessageListener(RedisMessageListenerContainer listenerContainer) {
        super(listenerContainer);
    }

    @Override
    public void onMessage(Message message, byte[] pattern) {

        String redisKey = (String) redisTemplate.getValueSerializer().deserialize(message.getBody());
        //针对特定的key进行处理
        System.out.println(redisKey);
    }
}
