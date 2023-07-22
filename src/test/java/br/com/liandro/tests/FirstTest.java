package br.com.liandro.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class FirstTest {

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

    @ParameterizedTest(name = "Test Case 003 - Parameterized Test : {index} - value: {arguments}")
    @CsvSource(value = {"peter,parker", "miles,morales", "gwen,stacy"})
    public void TC003(String param1, String param2) {
        System.out.println("param1 = " + param1 + ", param2 = " + param2);
    }

    @ParameterizedTest(name = "Test Case 004 - Parameterized Test : {index} - value: {arguments}")
    @CsvSource(value = {"peter?parker", "miles?morales", "gwen?stacy"}, delimiter = '?')
    public void TC004(String param1, String param2) {
        System.out.println("param1 = " + param1 + ", param2 = " + param2);
    }

    @ParameterizedTest(name = "Test Case 005 - Parameterized Test : {index} - value: {arguments}")
    @CsvFileSource(files = {"src/test/resources/params/shoppinglist.csv", "src/test/resources/params/shoppinglist2.csv"},
            numLinesToSkip = 1)
    public void TC005(String name, double price, int qty, String uom, String provider) {
        System.out.println("name = " + name + ", price = " + price + ", quantity = " + qty +
                ", unity of measure = " + uom + ", provider = " + provider );
    }

    List<String> sourceString() {
        return Arrays.asList("tomato", "carrot", "cabbage");
    }

    @ParameterizedTest(name = "Test Case 006 - Parameterized Test : {index} - value: {arguments}")
    @MethodSource(value = "sourceString")
    public void TC006(String param1) {
        System.out.println("param1 = " + param1);
    }

    Stream<String> sourceStringAsStream() {
        return Stream.of("beetroot", "apple", "pear");
    }

    @ParameterizedTest(name = "Test Case 007 - Parameterized Test : {index} - value: {arguments}")
    @MethodSource(value = "sourceStringAsStream")
    public void TC007(String param1) {
        System.out.println("param1 = " + param1);
    }

    List<Arguments> sourceList_StringDouble() {
        return Arrays.asList(
                arguments("tomato", 2.0),
                arguments("carrot", 4.5),
                arguments("cabbage", 7.8)
        );
    }

    @ParameterizedTest(name = "Test Case 008 - Parameterized Test : {index} - value: {arguments}")
    @MethodSource(value = "sourceList_StringDouble")
    public void TC008(String param1, double param2) {
        System.out.println("item = " + param1 + ", price = " + param2);
    }

    @ParameterizedTest(name = "Test Case 009 - Parameterized Test : {index} - value: {arguments}")
    @MethodSource(value = "br.com.liandro.tests.ParamProvider#sourceStream_StringDouble")
    public void TC009(String param1, double param2) {
        System.out.println("item = " + param1 + ", price = " + param2);
    }

}