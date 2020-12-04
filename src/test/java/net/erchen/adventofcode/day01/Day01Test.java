package net.erchen.adventofcode.day01;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Set;

import static java.util.stream.Collectors.toSet;
import static org.assertj.core.api.Assertions.assertThat;

class Day01Test {

    @Test
    void demoInput() {
        // given
        var input = Set.of(1721, 979, 366, 299, 675, 1456);

        // when
        var solution = Day01.solvePuzzle(input);

        // then
        assertThat(solution).isEqualTo(514579);
    }

    @Test
    void solutionInput() throws IOException {
        // given
        var input = Files.readAllLines(Path.of("src/test/resources/day01/input.txt")).stream().map(Integer::valueOf).collect(toSet());

        // when
        var solution = Day01.solvePuzzle(input);

        // then
        assertThat(solution).isEqualTo(703131);
    }

}