package net.erchen.adventofcode.day19;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class OrRuleTest {

    @Test
    void matchesValid() throws InvalidException {
        var rule = new OrRule(new MatchingRule('a'), new MatchingRule('b'));

        assertThat(rule.consume("a")).containsExactly("");
        assertThat(rule.consume("b")).containsExactly("");
        assertThat(rule.consume("aa")).containsExactly("a");
        assertThat(rule.consume("ba")).containsExactly("a");
    }

    @Test
    void matchesInvalid() {
        var rule = new OrRule(new MatchingRule('a'), new MatchingRule('b'));

        assertThatThrownBy(() -> rule.consume("c")).isInstanceOf(InvalidException.class);
        assertThatThrownBy(() -> rule.consume("ca")).isInstanceOf(InvalidException.class);
    }
}