package net.erchen.adventofcode.day09;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

import java.util.HashSet;
import java.util.List;
import java.util.stream.IntStream;

import static java.lang.Integer.max;
import static java.util.stream.Collectors.toList;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class eXchangeMaskingAdditionSystem {

    private final int preambleLength;
    private final List<Number> numbers;

    public static eXchangeMaskingAdditionSystem fromInput(List<String> input, int preambleLenght) {
        var numbers = input.stream().map(Long::valueOf).collect(toList());

        return new eXchangeMaskingAdditionSystem(preambleLenght,
                IntStream.range(0, input.size()).mapToObj(i ->
                        new Number(new HashSet<>(numbers.subList(max(i - preambleLenght, 0), i)), numbers.get(i))
                ).collect(toList()));

    }

    public Long findFirstInvalidNumber() {
        return numbers.stream().skip(preambleLength).filter(n -> !n.isValid()).findFirst().map(Number::getCurrentNumber).orElse(null);
    }

    public Long findEncryptionWeakness() {
        var statistics = findSummands(findFirstInvalidNumber()).stream().mapToLong(Long::valueOf).summaryStatistics();
        return statistics.getMin() + statistics.getMax();
    }

    List<Long> findSummands(long sumToFind) {
        for (int low = 0; low < numbers.size(); low++) {
            for (int high = low + 2; high < numbers.size(); high++) {
                var sum = numbers.subList(low, high).stream().mapToLong(Number::getCurrentNumber).sum();
                if (sum == sumToFind) {
                    return numbers.subList(low, high).stream().map(Number::getCurrentNumber).collect(toList());
                }
                if (sum > sumToFind) {
                    break;
                }
            }
        }
        return null;
    }

}
