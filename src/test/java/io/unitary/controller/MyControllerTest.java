package io.unitary.controller;

import io.unitary.exception.InvalidUserCredentialsException;
import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class MyControllerTest implements ControllerTest {

    private MyController myController;

    @BeforeEach
    public void setUp() {
        myController = new MyController();
    }

    @DisplayName("Testing index page name")
    @Test
    public void givenIndexPageName_validateIsCorrect() {
        String actual = myController.getIndexPage();
        assertEquals("index.html", actual,() -> "I'm adding "
            + "a larger "
            + " alert message"
        );
        assertThat(actual).isEqualTo("index.html");
    }

    @Disabled
    @Test
    public void testMultipleConditions() {
        String index = myController.getIndexPage();
        assertAll(
                () -> assertTrue(index.length() > 12, () -> "unexpected length for string"),
                () -> assertEquals("index.html2", index, () -> "Error message for assert " +
                        "number two, a long message " +
                        "I want to break in multiple lines"),
                () -> assertNotNull(index, () -> "The element is null")
        );
    }

    @DisplayName("Invalid user credentials")
    @Test
    public void assertThrows_InvalidUserCredentialsException() {
        assertThrows(InvalidUserCredentialsException.class, () -> {
           myController.throwExceptionMethod();
        });
    }
}
