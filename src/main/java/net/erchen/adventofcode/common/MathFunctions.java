package net.erchen.adventofcode.common;

public class MathFunctions {

    public static long factorial(int i) {
        return i <= 1 ? 1 : i * factorial(i - 1);
    }

    public static long binomialCoefficient(int n, int k) {
        return factorial(n) / (factorial(k) * factorial(n - k));
    }
}
