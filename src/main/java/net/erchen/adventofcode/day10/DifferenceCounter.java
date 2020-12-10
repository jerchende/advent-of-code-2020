package net.erchen.adventofcode.day10;

import lombok.Getter;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class DifferenceCounter {

    private final List<Integer> counter = new LinkedList<>();
    @Getter
    private final List<Integer> oneSequencesLengths = new LinkedList<>();
    private final AtomicInteger oneSequenceCounter = new AtomicInteger(0);

    public void countDifference(int difference) {
        counter.add(difference);
        if (difference == 1) {
            oneSequenceCounter.incrementAndGet();
        } else {
            oneSequencesLengths.add(oneSequenceCounter.getAndSet(0));
        }
    }

    public long getCount(int difference) {
        return counter.stream().filter(i -> i == difference).count();
    }

}
