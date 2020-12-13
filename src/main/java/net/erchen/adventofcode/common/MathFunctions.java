package net.erchen.adventofcode.common;

public class MathFunctions {

    public static long factorial(int i) {
        return i <= 1 ? 1 : i * factorial(i - 1);
    }

    public static long binomialCoefficient(int n, int k) {
        return factorial(n) / (factorial(k) * factorial(n - k));
    }

    public static long[] extendedEuclideanAlgorithm(long a, long b) {
        if (b == 0) {
            return new long[]{a, 1, 0};
        }

        long[] gcd = extendedEuclideanAlgorithm(b, a % b);
        return new long[]{gcd[0], gcd[2], gcd[1] - (a / b) * gcd[2]};
    }

}
