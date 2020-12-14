package net.erchen.adventofcode.day14;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SetMaskCommandTest {

    @Test
    void fromString() {
        var setMaskCommand = SetMaskCommand.fromString("mask = 1X01XXX001101X00001100X1010X10101101");

        assertThat(setMaskCommand.getBitMask()).isEqualTo(BitMask.fromString("1X01XXX001101X00001100X1010X10101101"));
    }

    @Test
    void isSetMaskCommand() {
        assertThat(SetMaskCommand.isSetMaskCommand("mask = 1X01XXX001101X00001100X1010X10101101")).isTrue();
        assertThat(SetMaskCommand.isSetMaskCommand("m4sk = 1X01XXX001101X00001100X1010X10101101")).isFalse();
        assertThat(SetMaskCommand.isSetMaskCommand("mem[52476] = 223677")).isFalse();
    }
}