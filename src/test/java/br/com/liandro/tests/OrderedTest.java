package br.com.liandro.tests;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.Arrays;
import java.util.List;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class OrderedTest {

    @Order(2)
    @Test
    @DisplayName("Test Case 001 - Sum")
    public void TC001() {
        Assertions.assertEquals(1 + 1, 2);
    }

    @ParameterizedTest(name = "Test Case 002 - Parameterized Test : {index} - value: {arguments}")
    @NullAndEmptySource //using null and empty values in addition to params values
    @ValueSource(strings = {"Dernival", "Alícia", "Elainy"})
    public void TC002(String theParam) {
        System.out.println(theParam);
    }

    List<String> sourceString() {
        return Arrays.asList("tomato", "carrot", "cabbage");
    }

    @Order(1)
    @ParameterizedTest(name = "Test Case 006 - Parameterized Test : {index} - value: {arguments}")
    @MethodSource(value = "sourceString")
    public void TC003(String param1) {
        System.out.println("param1 = " + param1);
    }

}