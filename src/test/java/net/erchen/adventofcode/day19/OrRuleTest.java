package net.erchen.adventofcode.day19;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class OrRuleTest {

    @Test
    void matchesValid() throws NotValidException {
        var rule = new OrRule(new MatchingRule('a'), new MatchingRule('b'));

        assertThat(rule.consume("a")).isEqualTo("");
        assertThat(rule.consume("b")).isEqualTo("");
        assertThat(rule.consume("aa")).isEqualTo("a");
        assertThat(rule.consume("ba")).isEqualTo("a");
    }

    @Test
    void matchesInvalid() {
        var rule = new OrRule(new MatchingRule('a'), new MatchingRule('b'));

        assertThatThrownBy(() -> rule.consume("c")).isInstanceOf(NotValidException.class);
        assertThatThrownBy(() -> rule.consume("ca")).isInstanceOf(NotValidException.class);
    }
}