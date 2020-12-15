package net.erchen.adventofcode.day15;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static net.erchen.adventofcode.day15.Memory.playMemory;
import static org.assertj.core.api.Assertions.assertThat;

class MemoryTest {

    @Test
    void part1_Demo() {
        assertThat(playMemory(new int[]{0, 3, 6}, 2020)).isEqualTo(436);
        assertThat(playMemory(new int[]{1, 3, 2}, 2020)).isEqualTo(1);
        assertThat(playMemory(new int[]{2, 1, 3}, 2020)).isEqualTo(10);
        assertThat(playMemory(new int[]{1, 2, 3}, 2020)).isEqualTo(27);
        assertThat(playMemory(new int[]{2, 3, 1}, 2020)).isEqualTo(78);
        assertThat(playMemory(new int[]{3, 2, 1}, 2020)).isEqualTo(438);
        assertThat(playMemory(new int[]{3, 1, 2}, 2020)).isEqualTo(1836);
    }

    @Test
    void part1_Solution() {
        assertThat(playMemory(new int[]{14, 8, 16, 0, 1, 17}, 2020)).isEqualTo(240);
    }

    @Test
    @Disabled
        // takes about 30 seconds to complete
    void part2_Demo() {
        assertThat(playMemory(new int[]{0, 3, 6}, 30000000)).isEqualTo(175594);
        assertThat(playMemory(new int[]{1, 3, 2}, 30000000)).isEqualTo(2578);
        assertThat(playMemory(new int[]{2, 1, 3}, 30000000)).isEqualTo(3544142);
        assertThat(playMemory(new int[]{1, 2, 3}, 30000000)).isEqualTo(261214);
        assertThat(playMemory(new int[]{2, 3, 1}, 30000000)).isEqualTo(6895259);
        assertThat(playMemory(new int[]{3, 2, 1}, 30000000)).isEqualTo(18);
        assertThat(playMemory(new int[]{3, 1, 2}, 30000000)).isEqualTo(362);
    }

    @Test
    void part2_Solution() {
        assertThat(playMemory(new int[]{14, 8, 16, 0, 1, 17}, 30000000)).isEqualTo(505);
    }
}