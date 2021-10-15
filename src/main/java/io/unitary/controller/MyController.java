package io.unitary.controller;

import io.unitary.exception.InvalidUserCredentialsException;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

    public String getIndexPage() {
        return "index.html";
    }

    public void throwExceptionMethod() throws InvalidUserCredentialsException {
        throw new InvalidUserCredentialsException();
    }
}
