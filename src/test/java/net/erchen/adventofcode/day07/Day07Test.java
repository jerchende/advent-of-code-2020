package net.erchen.adventofcode.day07;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class Day07Test {

    static List<String> solutionInput() throws IOException {
        return Files.readAllLines(Path.of("src/test/resources/day07/input.txt"));
    }

    static List<String> demoInput() throws IOException {
        return Files.readAllLines(Path.of("src/test/resources/day07/demo.txt"));
    }

    static List<String> demo2Input() throws IOException {
        return Files.readAllLines(Path.of("src/test/resources/day07/demo2.txt"));
    }

    @Test
    void countBagsContainingShinyGold_Demo() throws IOException {
        assertThat(Day07.countBagContaining(demoInput(), "shiny gold")).isEqualTo(4);
    }

    @Test
    void countBagsContainingShinyGold_Solution() throws IOException {
        assertThat(Day07.countBagContaining(solutionInput(), "shiny gold")).isEqualTo(177);
    }

    @Test
    void countBagsTotalForShinyGold_Demo() throws IOException {
        assertThat(Day07.countBagNeeded(demoInput(), "shiny gold")).isEqualTo(32);
    }

    @Test
    void countBagsTotalForShinyGold_Demo2() throws IOException {
        assertThat(Day07.countBagNeeded(demo2Input(), "shiny gold")).isEqualTo(126);
    }

    @Test
    void countBagsTotalForShinyGold_Solution() throws IOException {
        assertThat(Day07.countBagNeeded(solutionInput(), "shiny gold")).isEqualTo(34988);
    }
}