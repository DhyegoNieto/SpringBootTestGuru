package io.unitary.spring.junit4;

import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Primary
@Profile("yanny")
public class YannyWordGenerator implements WordGenerator {
    @Override
    public String generateWord() {
        return "Yanny";
    }
}
