package net.erchen.adventofcode.day07;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static java.util.Collections.emptyMap;
import static org.assertj.core.api.Assertions.assertThat;

class BagTest {
    @Test
    void canContain() {
        var red = new Bag("red", emptyMap());
        var blue = new Bag("blue", Map.of(red, 1));

        assertThat(blue.canContain(red)).isTrue();
    }

    @Test
    void canContainRecursive() {
        var red = new Bag("red", emptyMap());
        var green = new Bag("green", Map.of(red, 1));
        var blue = new Bag("blue", Map.of(green, 1));

        assertThat(blue.canContain(red)).isTrue();
    }

    @Test
    void canContainNegative() {
        var red = new Bag("red", emptyMap());
        var green = new Bag("green", emptyMap());
        var blue = new Bag("blue", Map.of(green, 1));

        assertThat(blue.canContain(red)).isFalse();
    }
}