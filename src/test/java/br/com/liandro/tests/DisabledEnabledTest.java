package br.com.liandro.tests;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledIf;
import org.junit.jupiter.api.condition.DisabledIfSystemProperty;
import org.junit.jupiter.api.condition.DisabledOnOs;
import org.junit.jupiter.api.condition.OS;

import java.time.DayOfWeek;
import java.time.LocalDateTime;

public class DisabledEnabledTest {

    @Test
    void firstTest() {
        System.out.println("This is the first test method");
    }

    @Test
    @Disabled(value = "Disabled for demo of @Disabled")
    void secondTest() {
        System.out.println("This is the second test method");
    }

    @Test
    @DisabledIf(value = "provider", disabledReason = "Disabled for demo of @DisabledIf, if today is saturday")
    void thirdTest() {
        System.out.println("This is the third test method");
    }

    @Test
    @DisabledOnOs(value = OS.MAC, disabledReason = "Disabled for demo of @DisabledOnOs")
    void fourthTest() {
        System.out.println("This is the fourth test method");
    }

    @Test
    @DisabledIfSystemProperty(named = "env", matches = "staging",
            disabledReason = "Disabled for demo of @DisabledIfSystemProperty")
    void fifthTest() {
        System.out.println("This is the fifth test method");
    }

    boolean provider() {
        return LocalDateTime.now().getDayOfWeek().equals(DayOfWeek.SATURDAY);
    }

}
