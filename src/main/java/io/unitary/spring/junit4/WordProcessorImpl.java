package io.unitary.spring.junit4;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@AllArgsConstructor
@Service
public class WordProcessorImpl implements WordProcessor {

    private final WordGenerator wordGenerator;

    @Override
    public String processWord() {
        String word = wordGenerator.generateWord();
        log.info(String.format("I heard %s", word));

        return word;
    }
}
