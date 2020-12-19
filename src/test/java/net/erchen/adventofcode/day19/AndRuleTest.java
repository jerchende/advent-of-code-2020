package net.erchen.adventofcode.day19;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class AndRuleTest {

    @Test
    void matchesValid() throws NotValidException {

        var ruleProvider = new RuleProvider();
        var rule1 = new RuleId(1);
        ruleProvider.put(rule1, new MatchingRule('a'));

        var rule = new AndRule(List.of(rule1, rule1, rule1), ruleProvider);

        assertThat(rule.consume("aaa")).isEqualTo("");
        assertThat(rule.consume("aaaa")).isEqualTo("a");
        assertThat(rule.consume("aaaaaa")).isEqualTo("aaa");
        assertThat(rule.consume("aaab")).isEqualTo("b");
    }

    @Test
    void matchesInValid() {

        var ruleProvider = new RuleProvider();
        var rule1 = new RuleId(1);
        ruleProvider.put(rule1, new MatchingRule('a'));

        var rule = new AndRule(List.of(rule1, rule1, rule1), ruleProvider);

        assertThatThrownBy(() -> rule.consume("aa")).isInstanceOf(NotValidException.class);
        assertThatThrownBy(() -> rule.consume("aba")).isInstanceOf(NotValidException.class);
        assertThatThrownBy(() -> rule.consume("abacc")).isInstanceOf(NotValidException.class);
    }

}