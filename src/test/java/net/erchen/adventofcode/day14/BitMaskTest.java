package net.erchen.adventofcode.day14;

import org.junit.jupiter.api.Test;

import static java.lang.Long.parseUnsignedLong;
import static org.assertj.core.api.Assertions.assertThat;

class BitMaskTest {

    @Test
    void convertWithXXXXXXXXXXXXXXXXXXXXXXXXXXXXX1XXXX0X() {
        var bitMask = BitMask.fromString("XXXXXXXXXXXXXXXXXXXXXXXXXXXXX1XXXX0X");

        assertThat(bitMask.applyMaskOnValue(11)).isEqualTo(73);
        assertThat(bitMask.applyMaskOnValue(101)).isEqualTo(101);
        assertThat(bitMask.applyMaskOnValue(0)).isEqualTo(64);
    }

    @Test
    void convertWithXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX() {
        var bitMask = BitMask.fromString("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");

        assertThat(bitMask.applyMaskOnValue(11)).isEqualTo(11);
        assertThat(bitMask.applyMaskOnValue(101)).isEqualTo(101);
        assertThat(bitMask.applyMaskOnValue(0)).isEqualTo(0);
    }

    @Test
    void convertWith000000000000000000000000000000000000() {
        var bitMask = BitMask.fromString("000000000000000000000000000000000000");

        assertThat(bitMask.applyMaskOnValue(11)).isEqualTo(0);
        assertThat(bitMask.applyMaskOnValue(101)).isEqualTo(0);
        assertThat(bitMask.applyMaskOnValue(0)).isEqualTo(0);
    }

    @Test
    void convertWith111111111111111111111111111111111111() {
        var bitMask = BitMask.fromString("111111111111111111111111111111111111");

        assertThat(bitMask.applyMaskOnValue(11)).isEqualTo(parseUnsignedLong("111111111111111111111111111111111111", 2));
        assertThat(bitMask.applyMaskOnValue(101)).isEqualTo(parseUnsignedLong("111111111111111111111111111111111111", 2));
        assertThat(bitMask.applyMaskOnValue(0)).isEqualTo(parseUnsignedLong("111111111111111111111111111111111111", 2));
    }

    @Test
    void getAddressMaskVariations() {
        var bitMask = BitMask.fromString("000000000000000000000000000000X1001X");

        assertThat(bitMask.applyMaskOnAddress(42)).containsExactlyInAnyOrder(26, 27, 58, 59);
    }
}