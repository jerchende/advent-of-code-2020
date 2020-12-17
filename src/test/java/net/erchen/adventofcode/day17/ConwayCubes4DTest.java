package net.erchen.adventofcode.day17;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ConwayCubes4DTest {
    static List<String> demoInput() throws IOException {
        return Files.readAllLines(Path.of("src/test/resources/day17/demo.txt"));
    }


    static List<String> solutionInput() throws IOException {
        return Files.readAllLines(Path.of("src/test/resources/day17/input.txt"));
    }


    @Test
    void shouldGetCube() throws IOException {
        ConwayCubes4D energySource4D = new ConwayCubes4D();
        energySource4D.init(demoInput());

        assertThat(energySource4D.getCube(0, 0, 0, 0)).isFalse();
        assertThat(energySource4D.getCube(1, 0, 0, 0)).isTrue();
        assertThat(energySource4D.getCube(1, 1, 0, 0)).isFalse();
        assertThat(energySource4D.getCube(1, 2, 0, 0)).isTrue();
    }

    @Test
    void shouldGetAdjacentCube() throws IOException {
        ConwayCubes4D energySource4D = new ConwayCubes4D();
        energySource4D.init(demoInput());

        assertThat(energySource4D.adjacentCubes(-100, -100, -100, -100)).hasSize(80).allMatch(b -> !b);
        assertThat(energySource4D.adjacentCubes(1, 1, 0, 0)).hasSize(80);
        assertThat(energySource4D.adjacentCubes(1, 1, 0, 0).stream().filter(b -> b).count()).isEqualTo(5);
    }

    @Test
    void countActiveAdjacentCube() throws IOException {
        ConwayCubes4D energySource4D = new ConwayCubes4D();
        energySource4D.init(demoInput());

        assertThat(energySource4D.countActiveAdjacentCubes(-100, -100, -100, -100)).isEqualTo(0);
        assertThat(energySource4D.countActiveAdjacentCubes(1, 1, 0, 0)).isEqualTo(5);
        assertThat(energySource4D.countActiveAdjacentCubes(0, 0, 0, 0)).isEqualTo(1);
        assertThat(energySource4D.countActiveAdjacentCubes(1, 1, 1, 0)).isEqualTo(5);
    }

    @Test
    void countActiveCubes() throws IOException {
        ConwayCubes4D energySource4D = new ConwayCubes4D();

        assertThat(energySource4D.countActiveCubes()).isEqualTo(0);

        energySource4D.init(demoInput());

        assertThat(energySource4D.countActiveCubes()).isEqualTo(5);
    }

    @Test
    void part2_Demo() throws IOException {
        ConwayCubes4D energySource4D = new ConwayCubes4D();
        energySource4D.init(demoInput());

        energySource4D.boot();

        assertThat(energySource4D.countActiveCubes()).isEqualTo(848);
    }

    @Test
    void part2_Solution() throws IOException {
        ConwayCubes4D energySource4D = new ConwayCubes4D();
        energySource4D.init(solutionInput());

        energySource4D.boot();

        assertThat(energySource4D.countActiveCubes()).isEqualTo(2460);
    }
}