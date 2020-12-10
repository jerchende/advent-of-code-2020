package net.erchen.adventofcode.day10;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DifferenceCounterTest {

    @Test
    void shouldCountDifferences() {
        var differenceCounter = new DifferenceCounter();

        differenceCounter.countDifference(1);
        differenceCounter.countDifference(2);
        differenceCounter.countDifference(2);
        differenceCounter.countDifference(3);
        differenceCounter.countDifference(3);
        differenceCounter.countDifference(3);
        differenceCounter.countDifference(3);
        differenceCounter.countDifference(3);

        assertThat(differenceCounter.getCount(1)).isEqualTo(1);
        assertThat(differenceCounter.getCount(2)).isEqualTo(2);
        assertThat(differenceCounter.getCount(3)).isEqualTo(5);
    }


    @Test
    void shouldCountSequences() {
        var differenceCounter = new DifferenceCounter();

        differenceCounter.countDifference(1);
        differenceCounter.countDifference(1);
        differenceCounter.countDifference(1);
        differenceCounter.countDifference(3);
        differenceCounter.countDifference(1);
        differenceCounter.countDifference(1);
        differenceCounter.countDifference(3);
        differenceCounter.countDifference(1);
        differenceCounter.countDifference(3);

        assertThat(differenceCounter.getOneSequencesLengths()).containsExactly(3, 2, 1);

    }
}