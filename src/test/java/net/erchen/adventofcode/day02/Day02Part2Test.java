package net.erchen.adventofcode.day02;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static net.erchen.adventofcode.day02.Day02Part2.countValidPassword;
import static net.erchen.adventofcode.day02.Day02Part2.isPasswordValid;
import static org.assertj.core.api.Assertions.assertThat;

class Day02Part2Test {

    static List<String> solutionInput() throws IOException {
        return Files.readAllLines(Path.of("src/test/resources/day02/input.txt"));
    }

    @Test
    void passwordValid() {
        assertThat(isPasswordValid("1-3 a: abcde")).isTrue();
        assertThat(isPasswordValid("1-3 b: cdefg")).isFalse();
        assertThat(isPasswordValid("2-9 c: ccccccccc")).isFalse();
    }

    @Test
    void countValidPasswords() {
        assertThat(countValidPassword(List.of("1-3 a: abcde", "1-3 b: cdefg", "2-9 c: ccccccccc"))).isEqualTo(1);
    }

    @Test
    void runSolution() throws IOException {
        assertThat(countValidPassword(solutionInput())).isEqualTo(404);
    }
}