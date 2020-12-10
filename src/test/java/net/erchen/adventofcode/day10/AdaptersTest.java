package net.erchen.adventofcode.day10;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class AdaptersTest {

    static List<String> demoInput() throws IOException {
        return Files.readAllLines(Path.of("src/test/resources/day10/demo.txt"));
    }

    static List<String> solutionInput() throws IOException {
        return Files.readAllLines(Path.of("src/test/resources/day10/input.txt"));
    }

    @Test
    void shouldGetDeviceJoiltage() {
        var adapters = Adapters.parse(List.of("3", "8", "17", "2"));

        assertThat(adapters.deviceJoltage()).isEqualTo(20);
    }

    @Test
    void magicNumbersPart1_Smap() throws IOException {
        var adapters = Adapters.parse(Arrays.asList("""
                16
                10
                15
                5
                1
                11
                7
                19
                6
                12
                4
                """.split("\n")));

        assertThat(adapters.magicNumberPart1()).isEqualTo(35);
    }

    @Test
    void magicNumbersPart1_Demo() throws IOException {
        var adapters = Adapters.parse(demoInput());

        assertThat(adapters.magicNumberPart1()).isEqualTo(220);
    }

    @Test
    void magicNumbersPart1_Solution() throws IOException {
        var adapters = Adapters.parse(solutionInput());

        assertThat(adapters.magicNumberPart1()).isEqualTo(2482);
    }

    @Test
    void magicNumbersPart2_Demo() throws IOException {
        var adapters = Adapters.parse(demoInput());

        assertThat(adapters.magicNumberPart2()).isEqualTo(19208);
    }

    @Test
    void magicNumbersPart2_Solution() throws IOException {
        var adapters = Adapters.parse(solutionInput());

        assertThat(adapters.magicNumberPart2()).isEqualTo(96717311574016L);
    }
}