package net.erchen.adventofcode.day08;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CommandTest {

    static List<String> demoInput() throws IOException {
        return Files.readAllLines(Path.of("src/test/resources/day08/demo.txt"));
    }

    @Test
    void shouldParseInput() throws IOException {
        var commands = Command.parseFromInput(demoInput());

        assertThat(commands).containsExactly(
                new Command(Operation.nop, 0),
                new Command(Operation.acc, 1),
                new Command(Operation.jmp, 4),
                new Command(Operation.acc, 3),
                new Command(Operation.jmp, -3),
                new Command(Operation.acc, -99),
                new Command(Operation.acc, 1),
                new Command(Operation.jmp, -4),
                new Command(Operation.acc, 6));
    }
}