package net.erchen.adventofcode.day19;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class MatchingRuleTest {

    @Test
    void consumeValid() throws NotValidException {
        assertThat(new MatchingRule('a').consume("a")).isEqualTo("");
        assertThat(new MatchingRule('a').consume("aa")).isEqualTo("a");
        assertThat(new MatchingRule('a').consume("aab")).isEqualTo("ab");
    }

    @Test
    void consumeInvalid() {
        assertThatThrownBy(() -> new MatchingRule('a').consume("b")).isInstanceOf(NotValidException.class);
    }
}