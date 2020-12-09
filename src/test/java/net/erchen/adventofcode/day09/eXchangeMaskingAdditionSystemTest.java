package net.erchen.adventofcode.day09;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class eXchangeMaskingAdditionSystemTest {

    static List<String> demoInput() throws IOException {
        return Files.readAllLines(Path.of("src/test/resources/day09/demo.txt"));
    }

    static List<String> solutionInput() throws IOException {
        return Files.readAllLines(Path.of("src/test/resources/day09/input.txt"));
    }


    @Test
    void findFirstInvalidNumber_Demo() throws IOException {
        var xmas = eXchangeMaskingAdditionSystem.fromInput(demoInput(), 5);

        assertThat(xmas.findFirstInvalidNumber()).isEqualTo(127);
    }

    @Test
    void findFirstInvalidNumber_Solution() throws IOException {
        var xmas = eXchangeMaskingAdditionSystem.fromInput(solutionInput(), 25);

        assertThat(xmas.findFirstInvalidNumber()).isEqualTo(15353384);
    }

    @Test
    void findSummands_Demo() throws IOException {
        var xmas = eXchangeMaskingAdditionSystem.fromInput(demoInput(), 5);

        assertThat(xmas.findSummands(127)).containsExactlyInAnyOrder(15L, 25L, 47L, 40L);
    }

    @Test
    void findEncryptionWeakness_Demo() throws IOException {
        var xmas = eXchangeMaskingAdditionSystem.fromInput(demoInput(), 5);

        assertThat(xmas.findEncryptionWeakness()).isEqualTo(62);
    }

    @Test
    void findEncryptionWeakness_Solution() throws IOException {
        var xmas = eXchangeMaskingAdditionSystem.fromInput(solutionInput(), 25);

        assertThat(xmas.findEncryptionWeakness()).isEqualTo(2466556);
    }
}