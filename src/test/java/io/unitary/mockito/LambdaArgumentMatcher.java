package io.unitary.mockito;

import io.unitary.controller.UserController;
import io.unitary.model.User;
import io.unitary.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
public class LambdaArgumentMatcher {

    @Mock(lenient = true)
    private UserService userService;

    @Test
    public void testArgumentMatchers() {
        //Given
        final String MATCH_ME = "MATCH_ME";
        User diego = new User("Diego", "email.com", 1);

        given(userService.getByName(argThat(argument -> argument.equalsIgnoreCase(MATCH_ME)))).willReturn(diego);

        //When
        User retrieved = userService.getByName("MATCH_ME");

        //Then
        assertThat(retrieved.getName()).isEqualTo("Diego");
    }

    @Test
    public void testArgumentMatchersNotAMatch() {
        //Given
        final String MATCH_ME = "NOT_A_MATCH";
        User diego = new User("Diego", "email.com", 1);

        given(userService.getByName(argThat(argument -> argument.equalsIgnoreCase(MATCH_ME)))).willReturn(diego);

        //When
        User retrieved = userService.getByName("MATCH_ME");

        //Then
        assertNull(retrieved);
    }

}
