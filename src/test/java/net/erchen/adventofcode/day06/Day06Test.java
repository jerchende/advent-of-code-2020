package net.erchen.adventofcode.day06;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.assertj.core.api.Assertions.assertThat;

class Day06Test {

    static String solutionInput() throws IOException {
        return Files.readString(Path.of("src/test/resources/day06/input.txt"));
    }

    @Test
    void demo() {
        assertThat(Day06.countUniqueAnswers("""
                abc
                                
                a
                b
                c
                                
                ab
                ac
                                
                a
                a
                a
                a
                                
                b
                """)).isEqualTo(11);
    }

    @Test
    void solution() throws IOException {
        assertThat(Day06.countUniqueAnswers(solutionInput())).isEqualTo(6530);
    }

    @Test
    void demoPart2() {
        assertThat(Day06.countCommonAnswers("""
                abc
                                
                a
                b
                c
                                
                ab
                ac
                                
                a
                a
                a
                a
                                
                b
                """)).isEqualTo(6);
    }

    @Test
    void solutionPart2() throws IOException {
        assertThat(Day06.countCommonAnswers(solutionInput())).isEqualTo(3323);
    }
}