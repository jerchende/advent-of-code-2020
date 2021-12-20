package net.erchen.adventofcode.day23;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class CrabCup {

    private Cup currentCup;
    private Cup[] cache;
    private final int highest;

    public static CrabCup fromInput(String input, boolean fill) {
        var inputArray = Arrays.asList(input.split(""));
        Collections.reverse(inputArray);

        var highest = fill ? 1_000_000 : 9;
        var cache = new Cup[highest + 1];
        var currentCup = Stream.concat(
                        fill ? IntStream.iterate(1000000, i -> i - 1).limit(999991).boxed() : Stream.of(),
                        inputArray.stream()
                                .map(Integer::parseInt)
                )
                .map(Cup::new)
                .peek(cup -> cache[cup.value()] = cup)
                .reduce((a, b) -> {
                    b.setNext(a);
                    return b;
                }).orElseThrow();

        var cup = currentCup;
        while (cup.next() != null) {
            cup = cup.next();
        }
        cup.setNext(currentCup);

        return new CrabCup(currentCup, cache, highest);
    }

    public static CrabCup fromInput(String input) {
        return fromInput(input, false);
    }

    public void move(int steps) {
        for (int i = 0; i < steps; i++) {
            var pickup = currentCup.setNext(currentCup.next(4));

            pickup.next(2).setNext(destination(pickup.stream().limit(3).map(Cup::value).collect(toList())).setNext(pickup));
            currentCup = currentCup.next();
        }
    }

    public void move() {
        move(1);
    }

    public String numberAfterOne() {
        return cache[1].stream().limit(9).skip(1).map(Cup::value).map(String::valueOf).collect(joining());
    }

    public long nextTwo() {
        return (long) cache[1].next(1).value() * cache[1].next(2).value();
    }

    Cup destination(List<Integer> excluded) {
        var destinationValue = currentCup.value() == 1 ? highest : currentCup.value() - 1;
        while (excluded.contains(destinationValue)) {
            destinationValue = destinationValue == 1 ? highest : destinationValue - 1;
        }
        return cache[destinationValue];
    }

    public String toString() {
        return currentCup.stream().limit(9).map(Cup::value).map(String::valueOf).collect(joining());
    }

    @RequiredArgsConstructor
    public static class Cup {
        private final int value;
        private Cup next;

        public int value() {
            return value;
        }

        public Cup next() {
            return next;
        }

        public Cup next(int steps) {
            return stream().skip(steps).findFirst().orElseThrow();
        }

        private Cup setNext(Cup newNext) {
            var oldNext = next;
            next = newNext;
            return oldNext;
        }

        @Override
        public String toString() {
            return "Cup " + value + " (next: " + next.value() + ")";
        }

        public Stream<Cup> stream() {
            return Stream.iterate(this, Cup::next);
        }
    }

}
