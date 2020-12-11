package net.erchen.adventofcode.day10;

import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;
import static net.erchen.adventofcode.common.MathFunctions.binomialCoefficient;

public class Adapters {
    private final List<Integer> availableAdapters;
    private final DifferenceCounter counter = new DifferenceCounter();

    public Adapters(List<Integer> availableAdapters) {
        this.availableAdapters = availableAdapters;

        IntStream.concat(IntStream.of(0, deviceJoltage()), adapters())
                .sorted()
                .reduce((a, b) -> {
                    counter.countDifference(b - a);
                    return b;
                }).orElseThrow();
    }

    public static Adapters parse(List<String> input) {
        return new Adapters(input.stream().map(Integer::valueOf).collect(toList()));
    }

    private IntStream adapters() {
        return availableAdapters.stream().mapToInt(Integer::valueOf);
    }

    public int deviceJoltage() {
        return adapters().max().orElse(0) + 3;
    }

    public long magicNumberPart1() {
        return counter.getCount(1) * counter.getCount(3);
    }

    public long magicNumberPart2() {
        return counter.getOneSequencesLengths().stream()
                .filter(i -> i > 1)
                .mapToLong(i -> binomialCoefficient(i, 2) + 1)
                .reduce((a, b) -> a * b)
                .orElse(0);
    }

}
