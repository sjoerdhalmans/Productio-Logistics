package com.productio.logistics.redis;

import com.productio.logistics.controllers.RedisReceiver;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.listener.PatternTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;

@Configuration
public class RedisConfig {
    @Bean
    RedisMessageListenerContainer container(RedisConnectionFactory connectionFactory,
                                            @Qualifier("notificationListenerAdapter") MessageListenerAdapter notificationListenerAdapter,
                                            @Qualifier("countListenerAdapter") MessageListenerAdapter countListenerAdapter) {

        RedisMessageListenerContainer container = new RedisMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        container.addMessageListener(notificationListenerAdapter,  new PatternTopic("notification"));
        container.addMessageListener(countListenerAdapter, new PatternTopic("count"));
        return container;
    }

    @Bean("notificationListenerAdapter")
    MessageListenerAdapter notificationListenerAdapter(RedisReceiver redisReceiver) {
        return new MessageListenerAdapter(redisReceiver, "receiveNotificationMessage");
    }

    @Bean("countListenerAdapter")
    MessageListenerAdapter countListenerAdapter(RedisReceiver redisReceiver) {
        return new MessageListenerAdapter(redisReceiver, "receiveCountMessage");
    }

    @Bean
    RedisReceiver receiver() {
        return new RedisReceiver();
    }

    @Bean
    StringRedisTemplate template(RedisConnectionFactory connectionFactory) {
        return new StringRedisTemplate(connectionFactory);
    }
}