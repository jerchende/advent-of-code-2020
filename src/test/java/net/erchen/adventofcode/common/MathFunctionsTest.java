package net.erchen.adventofcode.common;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MathFunctionsTest {

    @Test
    void factorial() {
        assertThat(MathFunctions.factorial(0)).isEqualTo(1);
        assertThat(MathFunctions.factorial(1)).isEqualTo(1);
        assertThat(MathFunctions.factorial(5)).isEqualTo(120);
        assertThat(MathFunctions.factorial(10)).isEqualTo(3_628_800);
    }

    @Test
    void binomialCoefficient() {
        assertThat(MathFunctions.binomialCoefficient(2, 2)).isEqualTo(1);
        assertThat(MathFunctions.binomialCoefficient(3, 2)).isEqualTo(3);
        assertThat(MathFunctions.binomialCoefficient(4, 2)).isEqualTo(6);
    }
}