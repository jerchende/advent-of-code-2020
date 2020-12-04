package net.erchen.adventofcode.day01;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class Day01 {

    public static int part1(Set<Integer> input) {
        return multipleTogether(findSummandsFor2020(input).orElseThrow());
    }

    public static int part2(Set<Integer> input) {
        return multipleTogether(input.stream()
                .flatMap(a -> findSummandsFor2020(input, a).stream())
                .findFirst()
                .orElseThrow());
    }

    private static Optional<List<Integer>> findSummandsFor2020(Set<Integer> input, int... additionalSummands) {
        var targetSum = 2020 - IntStream.of(additionalSummands).sum();

        return input.stream()
                .filter(i -> input.contains(targetSum - i))
                .findFirst()
                .map(i -> IntStream.concat(IntStream.of(i, targetSum - i), IntStream.of(additionalSummands)).boxed().collect(toList()));
    }

    private static int multipleTogether(List<Integer> summands) {
        return summands.stream().reduce((a, b) -> a * b).orElseThrow();
    }

}
