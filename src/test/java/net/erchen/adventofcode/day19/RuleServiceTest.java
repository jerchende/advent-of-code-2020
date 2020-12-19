package net.erchen.adventofcode.day19;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RuleServiceTest {


    static List<String> demoInput() throws IOException {
        return Files.readAllLines(Path.of("src/test/resources/day19/demo.txt"));
    }

    static List<String> demo2Input() throws IOException {
        return Files.readAllLines(Path.of("src/test/resources/day19/demo2.txt"));
    }

    static List<String> solutionInput() throws IOException {
        return Files.readAllLines(Path.of("src/test/resources/day19/input.txt"));
    }

    static List<String> part2 = List.of("8: 42 | 42 8", "11: 42 31 | 42 11 31");

    @Test
    void shouldInitRules() throws IOException {
        var ruleService = new RuleService();
        ruleService.parseRules(demoInput());

        var ruleProvider = ruleService.getRuleProvider();
        assertThat(ruleProvider)
                .hasSize(6)
                .hasEntrySatisfying(new RuleId(0), rule -> assertThat(rule).isInstanceOf(AndRule.class))
                .hasEntrySatisfying(new RuleId(1), rule -> assertThat(rule).isInstanceOf(OrRule.class))
                .hasEntrySatisfying(new RuleId(2), rule -> assertThat(rule).isInstanceOf(OrRule.class))
                .hasEntrySatisfying(new RuleId(3), rule -> assertThat(rule).isInstanceOf(OrRule.class))
                .containsEntry(new RuleId(4), new MatchingRule('a'))
                .containsEntry(new RuleId(5), new MatchingRule('b'));
    }

    @Test
    void countValidLines_Demo() throws IOException {

        var ruleService = new RuleService();
        ruleService.parseRules(demoInput());

        assertThat(ruleService.validLines(demoInput())).isEqualTo(2);
    }

    @Test
    void countValidLines_Solution_Part1() throws IOException {

        var ruleService = new RuleService();
        ruleService.parseRules(solutionInput());

        assertThat(ruleService.validLines(solutionInput())).isEqualTo(126);
    }


    @Test
    void countValidLines_Demo2() throws IOException {

        var ruleService = new RuleService();
        ruleService.parseRules(demo2Input());

        assertThat(ruleService.validLines(demo2Input())).isEqualTo(3);
    }

    @Test
    void countValidLines_Demo2_Part2() throws IOException {

        var ruleService = new RuleService();
        ruleService.parseRules(demo2Input());
        ruleService.parseRules(part2);

        assertThat(ruleService.validLines(demo2Input())).isEqualTo(12);
    }

    @Test
    void countValidLines_Solution_Part2() throws IOException {

        var ruleService = new RuleService();
        ruleService.parseRules(solutionInput());
        ruleService.parseRules(part2);

        assertThat(ruleService.validLines(solutionInput())).isEqualTo(282);
    }
}