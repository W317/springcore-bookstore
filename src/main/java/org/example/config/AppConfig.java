package org.example.config;

import org.example.repository.BookStoreRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan(basePackages = "org.example")
public class AppConfig {
    @Bean
    public BookStoreRepository bookStoreRepository() {
        return new BookStoreRepository();
    }

//    @Bean
//    public LoggingAspect loggingAspect() {
//        return new LoggingAspect();
//    }
}
