package br.com.liandro.tests;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class AssertionsTest {

    @Test
    void assertEqualsTest() {
        assertEquals("sameString", "sameString", "The string values were not equal");
    }

    @Test
    void assertEqualsListTest() {
        List<String> expectedValues = Arrays.asList("firstString", "secondString", "thirdString");
        List<String> actualValues = Arrays.asList("firstString", "secondString", "thirdString");

        assertEquals(expectedValues, actualValues);
    }

    @Test
    void assertArrayEqualsTest() {
        int[] expectedValues = {1, 2, 3};
        int[] actualValues = {1, 2, 3};

        assertArrayEquals(expectedValues, actualValues);
    }

    @Test
    void assertTrueTest() {
        assertTrue(true, "This boolean condition did evaluate to true");
    }

    @Test
    void assertThrowsTest() {
        assertThrows(NullPointerException.class, null);
    }

    @Test
    void assertAllTest() {
        assertAll(
                () -> assertEquals("sameString", "sameString", "The string values were not equal"),
                () -> assertThrows(NullPointerException.class, null),
                () -> assertTrue(true, "This boolean condition did evaluate to true")
        );
    }

}
