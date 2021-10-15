package io.unitary.spring.junit4;

import io.unitary.spring.config.BaseConfiguration;
import io.unitary.spring.config.YannyConfiguration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {BaseConfiguration.class, YannyConfiguration.class})
public class JUnit4LoadContextTest {

    @Autowired
    private WordProcessor wordProcessor;

    @Test
    public void testWhatIHeard() {
        String word = wordProcessor.processWord();

        assertThat("Yanny").isEqualTo(word);
    }

}
