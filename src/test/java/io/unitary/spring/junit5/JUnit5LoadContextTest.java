package io.unitary.spring.junit5;

import io.unitary.spring.config.BaseConfiguration;
import io.unitary.spring.config.LaurelConfiguration;
import io.unitary.spring.junit4.WordProcessor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import static org.assertj.core.api.Assertions.assertThat;

@SpringJUnitConfig(classes = {BaseConfiguration.class, LaurelConfiguration.class})
public class JUnit5LoadContextTest {

    @Autowired
    private WordProcessor wordProcessor;

    @Test
    public void testWordProcessor() {
        String word = wordProcessor.processWord();

        assertThat("Laurel").isEqualTo(word);
    }
}
