package net.erchen.adventofcode.day20;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ArrayHelperTest {


    @Test
    void rotate() {
        var input = new boolean[][]{{true, true}, {false, false}};
        var output = new boolean[2][2];

        ArrayHelper.rotate(input, output);

        assertThat(output).isDeepEqualTo(new boolean[][]{{false, true}, {false, true}});
    }

    @Test
    void flip() {
        var input = new boolean[][]{{true, true}, {false, false}};
        var output = new boolean[2][2];

        ArrayHelper.flip(input, output);

        assertThat(output).isDeepEqualTo(new boolean[][]{{false, false}, {true, true}});
    }
}