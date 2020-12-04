package net.erchen.adventofcode.day01;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Set;

import static java.util.stream.Collectors.toSet;
import static org.assertj.core.api.Assertions.assertThat;

class Day01Test {

    static final Set<Integer> DEMO_INPUT = Set.of(1721, 979, 366, 299, 675, 1456);

    static Set<Integer> solutionInput() throws IOException {
        return Files.readAllLines(Path.of("src/test/resources/day01/input.txt")).stream().map(Integer::valueOf).collect(toSet());
    }

    @Test
    void part1DemoInput() {
        // when
        var solution = Day01.part1(DEMO_INPUT);

        // then
        assertThat(solution).isEqualTo(514579);
    }

    @Test
    void part1SolutionInput() throws IOException {
        // given
        var input = solutionInput();

        // when
        var solution = Day01.part1(input);

        // then
        assertThat(solution).isEqualTo(703131);
    }

    @Test
    void part2DemoInput() {
        // when
        var solution = Day01.part2(DEMO_INPUT);

        // then
        assertThat(solution).isEqualTo(241861950);
    }


    @Test
    void part2SolutionInput() throws IOException {
        // given
        var input = solutionInput();

        // when
        var solution = Day01.part2(input);

        // then
        assertThat(solution).isEqualTo(272423970);
    }

}