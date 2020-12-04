package net.erchen.adventofcode.day01;

import java.util.Set;

public class Day01 {

    public static int solvePuzzle(Set<Integer> input) {
        return input.stream()
                .filter(a -> input.contains(2020 - a))
                .findFirst()
                .map(a -> a * (2020 - a))
                .orElse(0);
    }

}
