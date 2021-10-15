package io.unitary.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.stream.Stream;

public class UsingRepeatedTest {

    @RepeatedTest(value = 5, name = "{displayName} : {currentRepetition} - {totalRepetitions}")
    @DisplayName("Repeated Test Case")
    public void repeatedTest() {
        // TODO - impl
    }

    @RepeatedTest(5)
    public void repeatedTestWithDI(TestInfo testInfo, RepetitionInfo repetitionInfo) {
        System.out.println(testInfo.getDisplayName() + " : " + repetitionInfo.getCurrentRepetition());
    }

    @ParameterizedTest
    @ValueSource(strings = {"Mastercard", "Visa", "AMEX"})
    public void parametrizedTest(String value) {
        System.out.println("value: " +value);
    }

    @ParameterizedTest(name = "[{index}] {argumentsWithNames}")
    @DisplayName("EnumSource Test -")
    @EnumSource(UserType.class)
    public void enumSourceTest(UserType userType) {
        System.out.println(userType);
    }

    @DisplayName("CSV Source Test")
    @ParameterizedTest(name = "{displayName} - [{index}] {arguments}")
    @CsvSource({
            "FL, 1, 2",
            "CA, 2, 3",
            "MI, 3, 1",
    })
    void csvInputTest(String stateName, int val1, int val2) {
        System.out.println(stateName + " : " + val1 + " : " + val2);
    }

    @DisplayName("Test CVS from file")
    @ParameterizedTest(name = "{displayName} [{index}] {arguments}")
    @CsvFileSource(resources = "/input.csv", numLinesToSkip = 1)
    void csvFromFileTest(String stateName, int val1, int val2) {
        System.out.println(stateName + " : " + val1 + " : " + val2);
    }

    @DisplayName("Test source from method")
    @ParameterizedTest(name = "{displayName} [{index}] {arguments}")
    @MethodSource("getargs")
    void testSourceFromMethod(String stateName, int val1, int val2) {
        System.out.println(stateName + " : " + val1 + " : " + val2);
    }

    static Stream<Arguments> getargs() {
        return Stream.of(
                Arguments.of("FL", 3, 8),
                Arguments.of("CA", 9, 22),
                Arguments.of("MI", 65, 10)
        );
    }

    @DisplayName("Custom arguments provider test")
    @ParameterizedTest(name = "{displayName} [{index}] {arguments}")
    @ArgumentsSource(CustomArgumentsProvider.class)
    void customArgumentsProviderTest(String stateName, int val1, int val2) {
        System.out.println(stateName + " : " + val1 + " : " + val2);
    }
}
