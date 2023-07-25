package br.com.liandro.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class TaggedTest {

    @Test
    @Tag("sanity")
    public void TC001() {
        System.out.println("This is the first test method");
    }

    @Test
    @Tag("sanity")
    @Tag("acceptance")
    @DisplayName("US1234 - TC12 - this method is the second one")
    public void TC002() {
        System.out.println("This is the second test method");
    }

    @Test
    @Tag("acceptance")
    public void TC003() {
        System.out.println("This is the third test method");
    }

    @ParameterizedTest(name = "Run: {index} - value: {arguments}")
    @Tag("acceptance")
    @ValueSource(ints = {1, 5, 6})
    public void TC004(int theParam) {
        System.out.println("theParam = " + theParam);
    }

}