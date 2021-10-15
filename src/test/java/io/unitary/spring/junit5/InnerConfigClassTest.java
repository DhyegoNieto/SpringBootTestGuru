package io.unitary.spring.junit5;

import io.unitary.spring.config.YannyConfiguration;
import io.unitary.spring.junit4.WordGenerator;
import io.unitary.spring.junit4.WordProcessor;
import io.unitary.spring.junit4.WordProcessorImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import static org.assertj.core.api.Assertions.assertThat;

@SpringJUnitConfig(classes = {InnerConfigClassTest.InnerConfigurationClass.class, YannyConfiguration.class})
public class InnerConfigClassTest {

    @Configuration
    static class InnerConfigurationClass {

        @Bean
        public WordProcessor getWordProcessor(WordGenerator wordGenerator) {
            return new WordProcessorImpl(wordGenerator);
        }
    }

    @Autowired
    private WordProcessor wordProcessor;

    @Test
    public void testUsingInnerConfigurationClass() {
        String word = wordProcessor.processWord();

        assertThat("Yanny").isEqualTo(word);
    }
}
