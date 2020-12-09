package net.erchen.adventofcode.day09;

import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class NumberTest {

    @Test
    void isValid() {
        var previousNumbers = Set.of(1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L, 10L);

        assertThat(new Number(previousNumbers, 3L).isValid()).isTrue();
        assertThat(new Number(previousNumbers, 10L).isValid()).isTrue();
        assertThat(new Number(previousNumbers, 11L).isValid()).isTrue();
        assertThat(new Number(previousNumbers, 19L).isValid()).isTrue();

        assertThat(new Number(previousNumbers, 1L).isValid()).isFalse();
        assertThat(new Number(previousNumbers, 2L).isValid()).isFalse();
        assertThat(new Number(previousNumbers, 20L).isValid()).isFalse();
        assertThat(new Number(previousNumbers, 999L).isValid()).isFalse();

    }
}