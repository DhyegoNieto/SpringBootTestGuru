package io.unitary.spring.junit4;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
public class LaurelWordGenerator implements WordGenerator {
    @Override
    public String generateWord() {
        return "Laurel";
    }
}
