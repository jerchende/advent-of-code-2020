package net.erchen.adventofcode.day03;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static net.erchen.adventofcode.day03.Day03.part1;
import static net.erchen.adventofcode.day03.Day03.part2;
import static org.assertj.core.api.Assertions.assertThat;

class Day03Test {

    static List<String> demoInput() throws IOException {
        return Files.readAllLines(Path.of("src/test/resources/day03/demo.txt"));
    }

    static List<String> solutionInput() throws IOException {
        return Files.readAllLines(Path.of("src/test/resources/day03/input.txt"));
    }

    @Test
    void countTreesDemo() throws IOException {
        assertThat(part1(demoInput())).isEqualTo(7);
    }

    @Test
    void countTreesSolution() throws IOException {
        assertThat(part1(solutionInput())).isEqualTo(181);
    }

    @Test
    void part2Demo() throws IOException {
        assertThat(part2(demoInput())).isEqualTo(336);
    }

    @Test
    void part2Solution() throws IOException {
        assertThat(part2(solutionInput())).isEqualTo(1260601650);
    }
}