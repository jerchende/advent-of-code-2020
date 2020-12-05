package net.erchen.adventofcode.day04;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.assertj.core.api.Assertions.assertThat;

class Day04Test {

    static String demoInput() throws IOException {
        return Files.readString(Path.of("src/test/resources/day04/demo.txt"));
    }

    static String demoPart2Input() throws IOException {
        return Files.readString(Path.of("src/test/resources/day04/demoPart2.txt"));
    }

    static String solutionInput() throws IOException {
        return Files.readString(Path.of("src/test/resources/day04/input.txt"));
    }


    @Test
    void countValidPassesDemoPart1() throws IOException {
        var validPasses = Day04.countValidPassesPart1(demoInput());

        assertThat(validPasses).isEqualTo(2);
    }

    @Test
    void countValidPassesSolutionPart1() throws IOException {
        var validPasses = Day04.countValidPassesPart1(solutionInput());

        assertThat(validPasses).isEqualTo(196);
    }

    @Test
    void countValidPassesDemoPart2() throws IOException {
        var validPasses = Day04.countValidPassesPart2(demoPart2Input());

        assertThat(validPasses).isEqualTo(4);
    }

    @Test
    void countValidPassesSolutionPart2() throws IOException {
        var validPasses = Day04.countValidPassesPart2(solutionInput());

        assertThat(validPasses).isEqualTo(196);
    }
}