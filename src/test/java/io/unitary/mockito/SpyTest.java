package io.unitary.mockito;

import io.unitary.controller.UserController;
import io.unitary.model.User;
import io.unitary.service.MyService;
import io.unitary.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class SpyTest {

    @Mock
    private MyService myService;

    //@Mock(lenient = true)
    @Spy
    private UserService userService;

    @InjectMocks
    private UserController userController;

    @Captor
    ArgumentCaptor<User> userArgCaptor;

    private User mainUser;

    @BeforeEach
    public void setup() {
        // Given
        mainUser = new User("Diego", "email.com", 5);
        given(userService.countUsersByUsername(mainUser)).willAnswer(invocation ->{
            User userArg = invocation.getArgument(0);

            switch(userArg.getName()) {
                case "José":
                    return 1L;
                case "Rita":
                    return 2L;
                case "Diego":
                    return 4L;
                default:
                    throw new RuntimeException("Invalid Argument");
            }
        });
    }

    @Test
    public void testThrowException() {
        // Given
        doThrow(RuntimeException.class).when(userService).getByName(anyString());

        // Then
        assertThrows(RuntimeException.class, ()-> userController.getByName("Diego"));
    }

    @Test
    public void argMatcherTest() {
        // given
        given(userService.create(argThat(argument -> argument.getName().equalsIgnoreCase("Diego"))))
                .willThrow(new RuntimeException("Bad request"));

        // when
        assertThrows(RuntimeException.class, () -> userController.createUser(mainUser));
    }

    @Test
    public void testMockitoSpy() {
        // given
        given(userService.getByName(anyString())).willCallRealMethod();

        // when
        User user = userController.getByName("Diego");

        assertThat(user.getId()).isEqualTo(4L);
    }
}
