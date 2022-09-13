package com.EmployeeServices.Services.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

@Configuration
public class redis_config {

	@Bean
    public JedisConnectionFactory connectionFactory() {
        JedisConnectionFactory configuration=new JedisConnectionFactory();
        configuration.setHostName("localhost");
        configuration.setPort(6379);
        configuration.afterPropertiesSet();
        return configuration;
    }
    
    @Bean
    public RedisTemplate<String, Object>redisTemplate(){
         RedisTemplate<String, Object> template=new RedisTemplate<>();
         template.setConnectionFactory(connectionFactory());
         template.afterPropertiesSet();



        return template;
    }


}
