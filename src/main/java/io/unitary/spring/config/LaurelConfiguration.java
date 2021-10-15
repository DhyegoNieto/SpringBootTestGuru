package io.unitary.spring.config;

import io.unitary.spring.junit4.LaurelWordGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class LaurelConfiguration {

    @Profile("base")
    @Bean
    public LaurelWordGenerator getLaurelWordGenerator() {
        return new LaurelWordGenerator();
    }
}
