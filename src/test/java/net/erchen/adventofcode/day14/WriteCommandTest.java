package net.erchen.adventofcode.day14;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class WriteCommandTest {

    @Test
    void fromString() {
        var writeCommand = WriteCommand.fromString("mem[7] = 101");

        assertThat(writeCommand.getAddress()).isEqualTo(7);
        assertThat(writeCommand.getValue()).isEqualTo(101);
    }

    @Test
    void isWriteCommand() {
        assertThat(WriteCommand.isWriteCommand("mem[7] = 101")).isTrue();
        assertThat(WriteCommand.isWriteCommand("mem[999] = 4")).isTrue();
        assertThat(WriteCommand.isWriteCommand("mem[0] = 0")).isTrue();
        assertThat(WriteCommand.isWriteCommand("m3m[0] = 0")).isFalse();
        assertThat(WriteCommand.isWriteCommand("m3m[0] = 0")).isFalse();
        assertThat(WriteCommand.isWriteCommand("mask = 1X01XXX001101X00001100X1010X10101101")).isFalse();
    }

}