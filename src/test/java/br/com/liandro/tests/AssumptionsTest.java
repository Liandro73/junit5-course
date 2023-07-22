package br.com.liandro.tests;

import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class AssumptionsTest {

    @ParameterizedTest(name = "Test Case 002 - Parameterized Test : {index} - value: {arguments}")
    @ValueSource(strings = {"Dernival", "Alícia", "Elainy"})
    public void TC001(String theParam) {
        Assumptions.assumeTrue(!"Dernival".equals(theParam));
        System.out.println(theParam);
    }

}
