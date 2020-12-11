package net.erchen.adventofcode.day11;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static net.erchen.adventofcode.day11.SeatingSystem.SeatingAlgorithm.Part1;
import static net.erchen.adventofcode.day11.SeatingSystem.SeatingAlgorithm.Part2;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.atIndex;

class SeatingSystemTest {

    static List<String> demoInput() throws IOException {
        return Files.readAllLines(Path.of("src/test/resources/day11/demo.txt"));
    }

    static List<String> demoRoundInput(int round) throws IOException {
        return Files.readAllLines(Path.of("src/test/resources/day11/demo_round" + round + ".txt"));
    }

    static List<String> solutionInput() throws IOException {
        return Files.readAllLines(Path.of("src/test/resources/day11/input.txt"));
    }

    @Test
    void importFromFile() throws IOException {
        var seatingSystem = SeatingSystem.fromInput(demoInput(), Part1);

        assertThat(seatingSystem.getSeats()).contains("L.LL.LL.LL".toCharArray(), atIndex(0));
        assertThat(seatingSystem.getSeats()).contains("..L.L.....".toCharArray(), atIndex(6));
        assertThat(seatingSystem.getSeats()).contains("L.LLLLL.LL".toCharArray(), atIndex(9));
    }

    @Test
    void getSeatsAdjacent() throws IOException {
        var seatingSystem = SeatingSystem.fromInput(demoInput(), Part1);

        assertThat(seatingSystem.getSeatsAdjacent(0, 0)).contains(".LL".toCharArray());
        assertThat(seatingSystem.getSeatsAdjacent(1, 1)).contains("L.LLLL.L".toCharArray());
        assertThat(seatingSystem.getSeatsAdjacent(0, 9)).contains("LLL".toCharArray());
        assertThat(seatingSystem.getSeatsAdjacent(8, 4)).contains("LLLLLLLL".toCharArray());
        assertThat(seatingSystem.getSeatsAdjacent(9, 0)).contains("L..".toCharArray());
        assertThat(seatingSystem.getSeatsAdjacent(9, 9)).contains(".LL".toCharArray());
    }

    @Test
    void getOccupiedSeatsAdjacent() throws IOException {
        var seatingSystem = SeatingSystem.fromInput(demoRoundInput(1), Part1);

        assertThat(seatingSystem.getOccupiedSeatsAdjacent(0, 0)).isEqualTo(2);
        assertThat(seatingSystem.getOccupiedSeatsAdjacent(3, 3)).isEqualTo(5);
    }

    @Test
    void applySeatingRulesUntilChaosIsStabilized() throws IOException {
        var seatingSystem = SeatingSystem.fromInput(demoInput(), Part1);

        seatingSystem.applySeatingRulesUntilChaosIsStabilized();

        assertThat(seatingSystem).isEqualTo(SeatingSystem.fromInput(demoRoundInput(5), Part1));
    }

    @Test
    void countOccupiedSeatsPart1_Demo() throws IOException {
        var seatingSystem = SeatingSystem.fromInput(demoInput(), Part1);

        seatingSystem.applySeatingRulesUntilChaosIsStabilized();

        assertThat(seatingSystem.countOccupiedSeats()).isEqualTo(37);
    }

    @Test
    void countOccupiedSeatsPart1_Solution() throws IOException {
        var seatingSystem = SeatingSystem.fromInput(solutionInput(), Part1);

        seatingSystem.applySeatingRulesUntilChaosIsStabilized();

        assertThat(seatingSystem.countOccupiedSeats()).isEqualTo(2283);
    }

    @Test
    void countOccupiedSeatsPart2_Demo() throws IOException {
        var seatingSystem = SeatingSystem.fromInput(demoInput(), Part2);

        seatingSystem.applySeatingRulesUntilChaosIsStabilized();

        assertThat(seatingSystem.countOccupiedSeats()).isEqualTo(26);
    }

    @Test
    void countOccupiedSeatsPart2_Solution() throws IOException {
        var seatingSystem = SeatingSystem.fromInput(solutionInput(), Part2);

        seatingSystem.applySeatingRulesUntilChaosIsStabilized();

        assertThat(seatingSystem.countOccupiedSeats()).isEqualTo(2054);
    }
}