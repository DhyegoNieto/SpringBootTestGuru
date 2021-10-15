package io.unitary.spring.junit5;

import io.unitary.spring.junit4.WordProcessor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import static org.assertj.core.api.Assertions.assertThat;

@ActiveProfiles("yanny")
@SpringJUnitConfig(classes = {ActiveProfileTest.ActiveProfileConfTest.class})
public class ActiveProfileTest {

    @Autowired
    private WordProcessor wordProcessor;

    @Configuration
    @ComponentScan("io.unitary.spring.junit4")
    static class ActiveProfileConfTest { }

    @Test
    public void testGeneratedWord() {
        String word = wordProcessor.processWord();

        assertThat("Yanny").isEqualTo(word);
    }
}
