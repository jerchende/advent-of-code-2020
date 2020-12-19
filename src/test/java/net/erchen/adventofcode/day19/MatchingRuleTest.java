package net.erchen.adventofcode.day19;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class MatchingRuleTest {

    @Test
    void consumeValid() throws InvalidException {
        assertThat(new MatchingRule('a').consume("a")).containsExactly("");
        assertThat(new MatchingRule('a').consume("aa")).containsExactly("a");
        assertThat(new MatchingRule('a').consume("aab")).containsExactly("ab");
    }

    @Test
    void consumeInvalid() {
        assertThatThrownBy(() -> new MatchingRule('a').consume("b")).isInstanceOf(InvalidException.class);
    }
}