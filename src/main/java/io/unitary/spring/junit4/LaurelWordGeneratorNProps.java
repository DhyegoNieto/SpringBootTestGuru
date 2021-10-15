package io.unitary.spring.junit4;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile("laurel")
@Primary
@Component
public class LaurelWordGeneratorNProps implements WordGenerator {

    @Value("${say.word}")
    private String word;

    @Override
    public String generateWord() {
        return word;
    }
}