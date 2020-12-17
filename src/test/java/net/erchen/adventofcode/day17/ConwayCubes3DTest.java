package net.erchen.adventofcode.day17;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ConwayCubes3DTest {

    static List<String> demoInput() throws IOException {
        return Files.readAllLines(Path.of("src/test/resources/day17/demo.txt"));
    }


    static List<String> solutionInput() throws IOException {
        return Files.readAllLines(Path.of("src/test/resources/day17/input.txt"));
    }

    @Test
    void shouldInit() throws IOException {
        ConwayCubes3D energySource = new ConwayCubes3D();
        energySource.init(demoInput());

        assertThat(energySource.getCubesAtLayer(-1)).isEqualTo("""
                ...
                ...
                ...
                """);

        assertThat(energySource.getCubesAtLayer(0)).isEqualTo("""
                .#.
                ..#
                ###
                """);

        assertThat(energySource.getCubesAtLayer(1)).isEqualTo("""
                ...
                ...
                ...
                """);
    }

    @Test
    void shouldGetCube() throws IOException {
        ConwayCubes3D energySource = new ConwayCubes3D();
        energySource.init(demoInput());

        assertThat(energySource.getCube(0, 0, 0)).isFalse();
        assertThat(energySource.getCube(1, 0, 0)).isTrue();
        assertThat(energySource.getCube(1, 1, 0)).isFalse();
        assertThat(energySource.getCube(1, 2, 0)).isTrue();
    }

    @Test
    void shouldGetAdjacentCube() throws IOException {
        ConwayCubes3D energySource = new ConwayCubes3D();
        energySource.init(demoInput());

        assertThat(energySource.adjacentCubes(-100, -100, -100)).hasSize(26).allMatch(b -> !b);
        assertThat(energySource.adjacentCubes(1, 1, 0)).hasSize(26);
        assertThat(energySource.adjacentCubes(1, 1, 0).stream().filter(b -> b).count()).isEqualTo(5);
    }

    @Test
    void countActiveAdjacentCube() throws IOException {
        ConwayCubes3D energySource = new ConwayCubes3D();
        energySource.init(demoInput());

        assertThat(energySource.countActiveAdjacentCubes(-100, -100, -100)).isEqualTo(0);
        assertThat(energySource.countActiveAdjacentCubes(1, 1, 0)).isEqualTo(5);
        assertThat(energySource.countActiveAdjacentCubes(0, 0, 0)).isEqualTo(1);
        assertThat(energySource.countActiveAdjacentCubes(1, 1, 1)).isEqualTo(5);
    }

    @Test
    void countActiveCubes() throws IOException {
        ConwayCubes3D energySource = new ConwayCubes3D();

        assertThat(energySource.countActiveCubes()).isEqualTo(0);

        energySource.init(demoInput());

        assertThat(energySource.countActiveCubes()).isEqualTo(5);
    }

    @Test
    void part1_Demo() throws IOException {
        ConwayCubes3D energySource = new ConwayCubes3D();
        energySource.init(demoInput());

        energySource.boot();

        assertThat(energySource.countActiveCubes()).isEqualTo(112);
    }

    @Test
    void part1_Solution() throws IOException {
        ConwayCubes3D energySource = new ConwayCubes3D();
        energySource.init(solutionInput());

        energySource.boot();

        assertThat(energySource.countActiveCubes()).isEqualTo(424);
    }
}