package net.erchen.adventofcode.day13;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class BusServiceTest {

    static List<String> solutionInput() throws IOException {
        return Files.readAllLines(Path.of("src/test/resources/day13/input.txt"));
    }

    @Test
    void part1_Demo() {
        assertThat(BusService.part1(939, "7,13,x,x,59,x,31,19".split(","))).isEqualTo(295);
    }

    @Test
    void part1_Solution() throws IOException {
        var input = solutionInput();
        assertThat(BusService.part1(Integer.parseInt(input.get(0)), input.get(1).split(","))).isEqualTo(4207);
    }

    @Test
    void part2_Demo1() {
        assertThat(BusService.part2("2,3".split(","))).isEqualTo(2);
        assertThat(BusService.part2("3,5".split(","))).isEqualTo(9);
        assertThat(BusService.part2("3,x,5".split(","))).isEqualTo(3);
        assertThat(BusService.part2("17,x,13,19".split(","))).isEqualTo(3417);
        assertThat(BusService.part2("67,7,59,61".split(","))).isEqualTo(754018);
        assertThat(BusService.part2("67,x,7,59,61".split(","))).isEqualTo(779210);
        assertThat(BusService.part2("67,7,x,59,61".split(","))).isEqualTo(1261476);
        assertThat(BusService.part2("1789,37,47,1889".split(","))).isEqualTo(1202161486);
        assertThat(BusService.part2("7,13,x,x,59,x,31,19".split(","))).isEqualTo(1068781);
    }

    @Test
    void part2_Solution() throws IOException {
        assertThat(BusService.part2(solutionInput().get(1).split(","))).isEqualTo(725850285300475L);
    }

}