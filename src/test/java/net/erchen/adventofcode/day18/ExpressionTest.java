package net.erchen.adventofcode.day18;

import org.junit.jupiter.api.Test;

import static net.erchen.adventofcode.day18.Expression.RuleSet.Part1;
import static net.erchen.adventofcode.day18.Expression.RuleSet.Part2;
import static org.assertj.core.api.Assertions.assertThat;

class ExpressionTest {

    @Test
    void evaluate_Part1() {
        assertThat(new Expression("(2 + 3)", Part1).evaluate()).isEqualTo(5);
        assertThat(new Expression("2 + 3", Part1).evaluate()).isEqualTo(5);
        assertThat(new Expression("1 + 2 * 3 + 4 * 5 + 6", Part1).evaluate()).isEqualTo(71);
        assertThat(new Expression("1 + (2 * 3) + (4 * (5 + 6))", Part1).evaluate()).isEqualTo(51);
        assertThat(new Expression("2 * 3 + (4 * 5)", Part1).evaluate()).isEqualTo(26);
        assertThat(new Expression("5 + (8 * 3 + 9 + 3 * 4 * 3)", Part1).evaluate()).isEqualTo(437);
        assertThat(new Expression("5 * 9 * (7 * 3 * 3 + 9 * 3 + (8 + 6 * 4))", Part1).evaluate()).isEqualTo(12240);
        assertThat(new Expression("((2 + 4 * 9) * (6 + 9 * 8 + 6) + 6) + 2 + 4 * 2", Part1).evaluate()).isEqualTo(13632);
    }

    @Test
    void evaluate_Part2() {
        assertThat(new Expression("2 * 3 + (4 * 5)", Part2).evaluate()).isEqualTo(46);
        assertThat(new Expression("(2 + 3)", Part2).evaluate()).isEqualTo(5);
        assertThat(new Expression("2 + 3", Part2).evaluate()).isEqualTo(5);
        assertThat(new Expression("1 + 2 * 3 + 4 * 5 + 6", Part2).evaluate()).isEqualTo(231);
        assertThat(new Expression("1 + (2 * 3) + (4 * (5 + 6))", Part2).evaluate()).isEqualTo(51);
        assertThat(new Expression("5 + (8 * 3 + 9 + 3 * 4 * 3)", Part2).evaluate()).isEqualTo(1445);
        assertThat(new Expression("5 * 9 * (7 * 3 * 3 + 9 * 3 + (8 + 6 * 4))", Part2).evaluate()).isEqualTo(669060);
        assertThat(new Expression("((2 + 4 * 9) * (6 + 9 * 8 + 6) + 6) + 2 + 4 * 2", Part2).evaluate()).isEqualTo(23340);
    }
}