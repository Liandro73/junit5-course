package br.com.liandro.tests;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
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

    @Test
    void assertForMapTest() {
        Map<String, Integer> theMap = new HashMap<>();
        theMap.put("firstKey", 1);
        theMap.put("secondKey", 2);
        theMap.put("thirdKey", 3);

        assertThat(theMap, hasKey("secondKey"));
        assertThat(theMap, hasValue(3));
    }

    @Test
    void assertForList() {
        List<String> theList = Arrays.asList("firstString", "secondString", "thirdString");

        assertThat(theList, hasItem("thirdString"));
    }

    @Test
    void assertForAnyOf() {
        List<String> theList = Arrays.asList("firstString", "secondString", "thirdString");

        assertThat(theList, anyOf(hasItem("secondString"), hasItem("noString")));
    }

    @Test
    void assertForContainsAnyOrder() {
        List<String> theList = Arrays.asList("firstString", "secondString", "thirdString");

        assertThat(theList, containsInAnyOrder("thirdString", "firstString", "secondString"));
        assertThat(theList, containsInRelativeOrder("firstString", "secondString", "thirdString"));
    }

}
