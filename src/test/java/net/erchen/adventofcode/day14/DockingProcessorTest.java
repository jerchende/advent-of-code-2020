package net.erchen.adventofcode.day14;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class DockingProcessorTest {

    static List<String> demoInput() throws IOException {
        return Files.readAllLines(Path.of("src/test/resources/day14/demo.txt"));
    }

    static List<String> demo2Input() throws IOException {
        return Files.readAllLines(Path.of("src/test/resources/day14/demo2.txt"));
    }

    static List<String> solutionInput() throws IOException {
        return Files.readAllLines(Path.of("src/test/resources/day14/input.txt"));
    }

    @Test
    void applyBitMask() {
        var dockingProcessor = new DockingProcessor(false);

        dockingProcessor.applyCommand(SetMaskCommand.fromString("mask = XXXXXXXXXXXXXXXXXXXXXXXXXXXXX1XXXX0X"));

        assertThat(dockingProcessor.getBitMask()).isEqualTo(BitMask.fromString("XXXXXXXXXXXXXXXXXXXXXXXXXXXXX1XXXX0X"));
    }

    @Test
    void applyWriteNoRewrite() {
        var dockingProcessor = new DockingProcessor(false);

        dockingProcessor.applyCommand(WriteCommand.fromString("mem[8] = 11"));

        assertThat(dockingProcessor.getValues()).containsEntry(8L, 11L);
    }

    @Test
    void applyWriteWithRewrite() {
        var dockingProcessor = new DockingProcessor(true);

        dockingProcessor.applyCommand(SetMaskCommand.fromString("mask = 000000000000000000000000000000X1001X"));
        dockingProcessor.applyCommand(WriteCommand.fromString("mem[42] = 100"));

        assertThat(dockingProcessor.getValues())
                .containsEntry(26L, 100L)
                .containsEntry(27L, 100L)
                .containsEntry(58L, 100L)
                .containsEntry(59L, 100L);
    }

    @Test
    void getSumOfAllValues() {
        var dockingProcessor = new DockingProcessor(false);

        dockingProcessor.applyCommand(WriteCommand.fromString("mem[8] = 11"));
        dockingProcessor.applyCommand(WriteCommand.fromString("mem[8] = 13"));
        dockingProcessor.applyCommand(WriteCommand.fromString("mem[2] = 2"));

        assertThat(dockingProcessor.getSumOfAllValues()).isEqualTo(15); // 13 + 2
    }

    @Test
    void processDemoPart1() throws IOException {
        assertThat(DockingProcessor.fromCommands(demoInput(), false).getSumOfAllValues()).isEqualTo(165);
    }

    @Test
    void processSolutionPart1() throws IOException {
        assertThat(DockingProcessor.fromCommands(solutionInput(), false).getSumOfAllValues()).isEqualTo(10050490168421L);
    }

    @Test
    void processDemoPart2() throws IOException {
        assertThat(DockingProcessor.fromCommands(demo2Input(), true).getSumOfAllValues()).isEqualTo(208);
    }

    @Test
    void processSolutionPart2() throws IOException {
        assertThat(DockingProcessor.fromCommands(solutionInput(), true).getSumOfAllValues()).isEqualTo(2173858456958L);
    }
}