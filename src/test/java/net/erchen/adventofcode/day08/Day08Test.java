package net.erchen.adventofcode.day08;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class Day08Test {

    static List<String> demoInput() throws IOException {
        return Files.readAllLines(Path.of("src/test/resources/day08/demo.txt"));
    }

    static List<String> solutionInput() throws IOException {
        return Files.readAllLines(Path.of("src/test/resources/day08/input.txt"));
    }

    @Test
    void shouldGetCounterBeforeInfiniteLoop_Demo() throws IOException {
        assertThat(Day08.getValueBeforeInfiniteLoop(demoInput())).isEqualTo(5);
    }

    @Test
    void shouldGetCounterBeforeInfiniteLoop_Solution() throws IOException {
        assertThat(Day08.getValueBeforeInfiniteLoop(solutionInput())).isEqualTo(1654);
    }

    @Test
    void shouldRunCorrectedProgram_Demo() throws IOException {
        assertThat(Day08.runCorrectedProgram(demoInput())).isEqualTo(8);
    }

    @Test
    void shouldRunCorrectedProgram_Solution() throws IOException {
        assertThat(Day08.runCorrectedProgram(solutionInput())).isEqualTo(833);
    }
}