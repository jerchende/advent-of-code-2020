package net.erchen.adventofcode.day12;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static net.erchen.adventofcode.day12.ShipNavigator.calculateDistancePart1;
import static net.erchen.adventofcode.day12.ShipNavigator.calculateDistancePart2;
import static org.assertj.core.api.Assertions.assertThat;

class ShipNavigatorTest {


    static List<String> solutionInput() throws IOException {
        return Files.readAllLines(Path.of("src/test/resources/day12/input.txt"));
    }

    @Test
    void calculateDistancePart1_Demo() {
        assertThat(calculateDistancePart1(List.of("F10", "N3", "F7", "R90", "F11"))).isEqualTo(25);
    }

    @Test
    void calculateDistance_Solution() throws IOException {
        assertThat(calculateDistancePart1(solutionInput())).isEqualTo(439);
    }

    @Test
    void calculateDistancePart2_Demo() {
        assertThat(calculateDistancePart2(List.of("F10", "N3", "F7", "R90", "F11"))).isEqualTo(286);
    }

    @Test
    void calculateDistancePart2_Solution() throws IOException {
        assertThat(calculateDistancePart2(solutionInput())).isEqualTo(12385);
    }
}