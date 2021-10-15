package io.unitary.util;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

@Tag("utility")
public class UtilityTests {

    @Test
    @EnabledOnOs(OS.MAC)
    public void runOnMacTest() {

    }

    @Test
    @EnabledOnOs(OS.WINDOWS)
    public void runOnWindowsTest() {
        String actual = "main";
        assertThat(actual, is("main"));
    }

    @Test
    @EnabledOnJre(JRE.JAVA_8)
    public void runOnJRE8Test() {

    }

    @Test
    @EnabledOnJre(JRE.JAVA_11)
    public void runOnJRE11Test() {

    }

    @Test
    @EnabledIfEnvironmentVariable(named = "USERNAME", matches = "diego.nietop")
    public void runIfMatchesEnvVariableDiego() {

    }

    @Test
    @EnabledIfEnvironmentVariable(named = "USERNAME", matches = "pepe")
    public void runIfMatchesEnvVariablePepe() {

    }
}
