package io.unitary.spring.config;

import io.unitary.spring.junit4.WordGenerator;
import io.unitary.spring.junit4.WordProcessor;
import io.unitary.spring.junit4.WordProcessorImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class BaseConfiguration {

    @Profile("base")
    @Bean
    public WordProcessor getWordProcessor(WordGenerator wordGenerator) {
        return new WordProcessorImpl(wordGenerator);
    }
}
