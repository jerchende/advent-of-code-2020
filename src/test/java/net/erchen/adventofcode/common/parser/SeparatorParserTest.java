package net.erchen.adventofcode.common.parser;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SeparatorParserTest {

    @Test
    void shouldParseSeparator() {
        // given
        var input = """
                aaaa
                bbbb
                                
                cccc
                dddd
                                
                eeee
                ffff
                """;

        // when
        var parsedResult = SeparatorParser.parseInput(input, "\n\n", s -> s);

        // then
        assertThat(parsedResult).containsExactly("aaaa\nbbbb", "cccc\ndddd", "eeee\nffff");
    }


    @Test
    void shouldParseSeparator_SingleEntry() {
        // given
        var input = """
                aaaa
                bbbb
                """;

        // when
        var parsedResult = SeparatorParser.parseInput(input, "\n\n", s -> s);

        // then
        assertThat(parsedResult).containsExactly("aaaa\nbbbb");
    }

    @Test
    void shouldParseSeparator_NoEntry() {
        // given
        var input = "";

        // when
        var parsedResult = SeparatorParser.parseInput(input, "\n\n", s -> s);

        // then
        assertThat(parsedResult).isEmpty();
    }

}