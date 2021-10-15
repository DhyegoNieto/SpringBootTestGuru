package io.unitary.service;

import io.unitary.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Nested tests - ")
public class NestedTests {
    private MyService myService;
    @BeforeEach
    public void setUp() {
        myService = new MyService();
        System.out.println("Main test setUp");
    }

    @Nested
    @DisplayName(" Nested Class One")
    class NestedClassOne {
        @BeforeEach
        public void setUp() {
            System.out.println("Nested class one setUp");
        }

        @Test
        @DisplayName("Nested test one - list size")
        public void testUserListSize() {
            int size = myService.getUserList().size();
            assertThat(size).isGreaterThan(2);
        }

        @DisplayName("Nested Class Two")
        @Nested
        class NestedClassTwo {
            @BeforeEach
            public void setUp() {
                System.out.println("Nested class one.two setUp");
            }

            @Test
            @DisplayName("User List Size Is Not Zero")
            public void testUserListSize_isZero() {
                int size = myService.getUserList().size();
                assertThat(size).isNotZero();
            }
        }
    }

    @Test
    @DisplayName("User List Size is Zero")
    public void testUserListSize_isZero() {
        int size = myService.getUserList().size();
        assertThat(size).isNotNegative();
    }
}
