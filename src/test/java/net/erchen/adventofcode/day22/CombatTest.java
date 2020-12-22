package net.erchen.adventofcode.day22;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Duration;
import java.util.LinkedList;
import java.util.List;

import static net.erchen.adventofcode.day22.Player.Player1;
import static net.erchen.adventofcode.day22.Player.Player2;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;

class CombatTest {

    static List<String> demoInput() throws IOException {
        return Files.readAllLines(Path.of("src/test/resources/day22/demo.txt"));
    }

    static List<String> loopInput() throws IOException {
        return Files.readAllLines(Path.of("src/test/resources/day22/loop.txt"));
    }

    static List<String> solutionInput() throws IOException {
        return Files.readAllLines(Path.of("src/test/resources/day22/input.txt"));
    }

    @Test
    void fromInput() throws IOException {
        var combat = Combat.fromInput(demoInput());

        assertThat(combat.getPlayer1()).containsExactly(new Card(9), new Card(2), new Card(6), new Card(3), new Card(1));
        assertThat(combat.getPlayer2()).containsExactly(new Card(5), new Card(8), new Card(4), new Card(7), new Card(10));
    }

    @Test
    void playCombat_Demo() throws IOException {
        var combat = Combat.fromInput(demoInput());

        var gameResults = combat.playCombat();
        assertThat(gameResults.getWinner()).isEqualTo(Player2);
        assertThat(gameResults.getWinningCards()).containsExactly(new Card(3), new Card(2), new Card(10), new Card(6), new Card(8), new Card(5), new Card(9), new Card(4), new Card(7), new Card(1));
        assertThat(gameResults.getWinningPlayerScore()).isEqualTo(306);
    }

    @Test
    void playCombat_Solution() throws IOException {
        var combat = Combat.fromInput(solutionInput());

        var gameResults = combat.playCombat();
        assertThat(gameResults.getWinner()).isEqualTo(Player1);
        assertThat(gameResults.getWinningPlayerScore()).isEqualTo(31308);
    }

    @Test
    void shouldSlice() {
        var cards = new LinkedList<>(List.of(new Card(1), new Card(2), new Card(3)));

        assertThat(Combat.slice(cards, 2)).containsExactly(new Card(1), new Card(2));
        assertThat(Combat.slice(cards, 5)).containsExactly(new Card(1), new Card(2), new Card(3));
    }

    @Test
    void playRecursiveCombat_Demo() throws IOException {
        var combat = Combat.fromInput(demoInput());

        var gameResults = combat.playRecursiveCombat();
        assertThat(gameResults.getWinner()).isEqualTo(Player2);
        assertThat(gameResults.getWinningCards()).containsExactly(new Card(7), new Card(5), new Card(6), new Card(2), new Card(4), new Card(1), new Card(10), new Card(8), new Card(9), new Card(3));
        assertThat(gameResults.getWinningPlayerScore()).isEqualTo(291);
    }

    @Test
    void playRecursiveCombat_Solution() {
        assertTimeoutPreemptively(Duration.ofSeconds(5), () -> {

            var combat = Combat.fromInput(solutionInput());

            var gameResults = combat.playRecursiveCombat();
            assertThat(gameResults.getWinner()).isEqualTo(Player1);
            assertThat(gameResults.getWinningPlayerScore()).isEqualTo(33647);
        });
    }

}