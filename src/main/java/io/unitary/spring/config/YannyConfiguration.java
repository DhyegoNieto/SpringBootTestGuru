package io.unitary.spring.config;

import io.unitary.spring.junit4.YannyWordGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class YannyConfiguration {

    @Profile("base")
    @Bean
    public YannyWordGenerator getYannyWordGenerator() {
        return new YannyWordGenerator();
    }
}
