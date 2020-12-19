package net.erchen.adventofcode.day19;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class AndRuleTest {

    @Test
    void matchesValid() throws InvalidException {

        var ruleProvider = new RuleProvider();
        var rule1 = new RuleId(1);
        ruleProvider.put(rule1, new MatchingRule('a'));

        var rule = new AndRule(List.of(rule1, rule1, rule1), ruleProvider);

        assertThat(rule.consume("aaa")).containsExactly("");
        assertThat(rule.consume("aaaa")).containsExactly("a");
        assertThat(rule.consume("aaaaaa")).containsExactly("aaa");
        assertThat(rule.consume("aaab")).containsExactly("b");
    }

    @Test
    void matchesInValid() {

        var ruleProvider = new RuleProvider();
        var rule1 = new RuleId(1);
        ruleProvider.put(rule1, new MatchingRule('a'));

        var rule = new AndRule(List.of(rule1, rule1, rule1), ruleProvider);

        assertThatThrownBy(() -> rule.consume("aa")).isInstanceOf(InvalidException.class);
        assertThatThrownBy(() -> rule.consume("aba")).isInstanceOf(InvalidException.class);
        assertThatThrownBy(() -> rule.consume("abacc")).isInstanceOf(InvalidException.class);
    }

}