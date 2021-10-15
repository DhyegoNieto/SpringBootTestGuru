package io.unitary.mockito;

import io.unitary.controller.UserController;
import io.unitary.model.User;
import io.unitary.service.MyService;
import io.unitary.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class TestInteractions {

    @Mock
    private UserService userService;

    @Mock
    private MyService myService;

    @InjectMocks
    private UserController userController;

    @Test
    public void testNoInteractions() {
        // Given
        User laura = new User("Laura", "email.com", 4);
        given(userService.countUsersByUsername(laura)).willReturn(4L);

        // When
        userController.getCountByName(laura);

        // Then
        verifyNoInteractions(myService);
    }

    @Test
    public void testNoMoreInteractions() {
        // Given
        User laura = new User("Laura", "email.com", 4);
        given(userService.countUsersByUsername(laura)).willReturn(0L);

        // When
        userController.getCountByName(laura);

        // Then
        verify(myService, atLeastOnce()).getUserList();
        verifyNoMoreInteractions(userService);
    }
}
