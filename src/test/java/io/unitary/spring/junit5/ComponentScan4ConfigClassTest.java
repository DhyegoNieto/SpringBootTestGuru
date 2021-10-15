package io.unitary.spring.junit5;

import io.unitary.spring.junit4.WordProcessor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import static org.assertj.core.api.Assertions.assertThat;

@SpringJUnitConfig(classes = {ComponentScan4ConfigClassTest.ComponentScanConfig.class})
public class ComponentScan4ConfigClassTest {

    @Configuration
    @ComponentScan("io.unitary.spring.junit4")
    public static class ComponentScanConfig {

    }

    @Autowired
    private WordProcessor wordProcessor;

    @Test
    public void testUsingInnerConfigurationClass() {
        String word = wordProcessor.processWord();

        assertThat("Yanny").isEqualTo(word);
    }
}
