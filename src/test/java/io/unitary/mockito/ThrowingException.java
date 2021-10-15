package io.unitary.mockito;

import io.unitary.controller.UserController;
import io.unitary.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class ThrowingException {

    @Mock
    private UserService userService;

    @InjectMocks
    private UserController userController;

    @Test
    public void assertThrowingException() {
        doThrow(RuntimeException.class).when(userService).getById(1L);

        assertThrows(RuntimeException.class, () -> userController.getById(1L));

        verify(userService).getById(anyLong());
    }

    @Test
    public void testAssertThrowsDBBStyle() {
        given(userService.getById(1L)).willThrow(new RuntimeException("User service error"));

        assertThrows(RuntimeException.class, () -> userController.getById(1L));

        then(userService).should().getById(anyLong());
    }
}
