package net.erchen.adventofcode.day20;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BorderTest {

    @Test
    void shouldFlipBorder() {
        var border = Border.fromString("#....#####");

        assertThat(border.flipBorder()).isEqualTo(Border.fromString("#####....#"));
    }
}