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

    @Test
    void extendedEuclideanAlgorithm() {
        assertThat(MathFunctions.extendedEuclideanAlgorithm(9, 15)).containsExactly(3, 2, -1);
        assertThat(MathFunctions.extendedEuclideanAlgorithm(44, 12)).containsExactly(4, -1, 4);
        assertThat(MathFunctions.extendedEuclideanAlgorithm(44, 11)).containsExactly(11, 0, 1);
        assertThat(MathFunctions.extendedEuclideanAlgorithm(44, 4)).containsExactly(4, 0, 1);
        assertThat(MathFunctions.extendedEuclideanAlgorithm(17, 15)).containsExactly(1, -7, 8);
        assertThat(MathFunctions.extendedEuclideanAlgorithm(93, 72)).containsExactly(3, 7, -9);
    }

}