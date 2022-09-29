package com.ilionx.foodapp.config;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.context.annotation.Bean;

@TestConfiguration
public class BeanConfig {

    @Bean
    public TestRestTemplate restTemplate(){
        return new TestRestTemplate();
    }
}
