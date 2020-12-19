package net.erchen.adventofcode.day18;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static net.erchen.adventofcode.day18.Expression.RuleSet.Part1;
import static net.erchen.adventofcode.day18.Expression.RuleSet.Part2;
import static org.assertj.core.api.Assertions.assertThat;

class ExpressionsTest {

    static List<String> solutionInput() throws IOException {
        return Files.readAllLines(Path.of("src/test/resources/day18/input.txt"));
    }

    @Test
    void shouldSumAllValues_Part1_Solution() throws IOException {
        assertThat(Expressions.sumAllExpressions(solutionInput(), Part1)).isEqualTo(4940631886147L);
    }

    @Test
    void shouldSumAllValues_Part2_Solution() throws IOException {
        assertThat(Expressions.sumAllExpressions(solutionInput(), Part2)).isEqualTo(283582817678281L);
    }
}