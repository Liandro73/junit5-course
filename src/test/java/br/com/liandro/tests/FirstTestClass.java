package br.com.liandro.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

public class FirstTestClass {

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

}