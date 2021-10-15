package io.unitary.mockito;

import io.unitary.controller.UserController;
import io.unitary.model.User;
import io.unitary.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;

@ExtendWith(MockitoExtension.class)
public class ArgumentCaptorNAnswer {

    @Mock
    private UserService userService;

    @InjectMocks
    private UserController userController;

    @Captor
    private ArgumentCaptor<User> userArgumentCaptor;

    @BeforeEach
    public void setup() {
        given(userService.countUsersByUsername(userArgumentCaptor.capture()))
                .willAnswer(invocation -> {
                    User user = invocation.getArgument(0);

                    switch(user.getName()) {
                        case "José":
                            return 1L;
                        case "Rita":
                            return 2L;
                        case "Fabian":
                            return 3L;
                        default:
                            throw new RuntimeException("Invalid argument");
                    }
                });
    }


    @DisplayName("Argument Captor test")
    @Test
    public void testArgumentoCaptor() {

        // Given
        User dad = new User("José", "email.com", 7);
        ArgumentCaptor<User> argumentCaptor = ArgumentCaptor.forClass(User.class);
        given(userService.countUsersByUsername(argumentCaptor.capture())).willReturn(1L);

        // When
        Long count = userController.getCountByName(dad);

        // Then
        assertThat(argumentCaptor.getValue().getName()).isEqualTo("José");
    }

    @Test
    @DisplayName("Argument Captor with Annotations")
    public void testArgumentCaptorAnnotation() {
        // Given
        User dad = new User("José", "email.com", 7);
        given(userService.countUsersByUsername(userArgumentCaptor.capture())).willReturn(5L);

        // When
        userController.getCountByName(dad);

        // Then
        assertThat(userArgumentCaptor.getValue().getId()).isGreaterThan(5);
    }

    @DisplayName("Test by using argument captor at setup")
    @Test
    public void testUsingArgumentCaptorSetup() {
        // Given
        User mom = new User("Rita", "email.com", 2);

        // When
        userController.getCountByName(mom);

        // Then
        assertThat(2L).isEqualTo(userArgumentCaptor.getValue().getId());
    }

}
