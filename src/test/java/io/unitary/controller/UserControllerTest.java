package io.unitary.controller;

import io.unitary.model.User;
import io.unitary.service.UserService;
import io.unitary.service.impl.UserServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.SQLException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.BDDMockito.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserControllerTest implements ControllerTest {

    @Mock(lenient = true)
    private UserService userService;

    @InjectMocks
    private UserController userController;


    @Test
    public void testUserName() {
        assertEquals("Diego", userService.getById(1L).getName(), ()-> "" +
                "My Ultra Long" +
                "Message for the test");
    }

    @DisplayName("Testing mockito BDD")
    @Test
    public void givenUserName_thenFindByName() {
        // Given
        final String USERNAME = "Laura";
        User laura = new User("Laura", "email.com", 4);
        given(userService.getByName(USERNAME)).willReturn(laura);

        // When
        User userByUsername = userController.getByName(USERNAME);

        // Then
        then(userService).should().getByName(anyString());
        assertThat(userByUsername.getName()).isEqualTo("Laura");
    }

    @DisplayName("Test with argument matchers")
    @Test
    public void testArgumentMatcher() {
        // Given
        final String username = "Diego";
        given(userService.getByName(argThat(argument -> argument.equalsIgnoreCase("Diego2"))))
                .willReturn(new User("Diego", "email.com", 1));

        // When
        User user = userController.getByName(username);

        // Then
        assertNull(user);
    }

    @DisplayName("Testing assertThrows")
    @Test
    public void testThrowingExceptions() {
        // Given
        final String USERNAME = "Laura";
        doThrow(RuntimeException.class).when(userService).getByName(anyString());

        assertThrows(RuntimeException.class, () -> userController.getByName(USERNAME));
    }
}
