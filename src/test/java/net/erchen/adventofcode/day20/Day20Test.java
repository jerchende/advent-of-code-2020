package net.erchen.adventofcode.day20;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.assertj.core.api.Assertions.assertThat;

class Day20Test {

    static String demoInput() throws IOException {
        return Files.readString(Path.of("src/test/resources/day20/demo.txt"));
    }

    static String solutionInput() throws IOException {
        return Files.readString(Path.of("src/test/resources/day20/input.txt"));
    }

    Day20 demo;
    Day20 solution;

    @BeforeEach
    void setUp() throws IOException {
        demo = new Day20(demoInput());
        solution = new Day20(solutionInput());
    }

    @Test
    void getEdgeMultipliedDemo() {
        assertThat(demo.getEdgeProduct()).isEqualTo(20899048083289L);
    }

    @Test
    void getEdgeMultipliedSolution() {
        assertThat(solution.getEdgeProduct()).isEqualTo(18262194216271L);
    }
}