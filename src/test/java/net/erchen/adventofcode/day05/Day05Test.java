package net.erchen.adventofcode.day05;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class Day05Test {

    static List<String> solutionInput() throws IOException {
        return Files.readAllLines(Path.of("src/test/resources/day05/input.txt"));
    }

    @Test
    void shouldFindHighestNumberDemo() {
        var highestSeatId = Day05.findHighestSeatId(List.of("BFFFBBFRRR", "FFFBBBFRRR", "BBFFBBFRLL"));

        assertThat(highestSeatId).isEqualTo(820);
    }

    @Test
    void shouldFindHighestNumberSolution() throws IOException {
        var highestSeatId = Day05.findHighestSeatId(solutionInput());

        assertThat(highestSeatId).isEqualTo(970);
    }

    @Test
    void findYourSeatId() throws IOException {
        var highestSeatId = Day05.findYourSeatId(solutionInput());

        assertThat(highestSeatId).isEqualTo(587);
    }
}