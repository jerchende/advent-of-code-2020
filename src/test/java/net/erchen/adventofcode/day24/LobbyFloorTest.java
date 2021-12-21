package net.erchen.adventofcode.day24;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static net.erchen.adventofcode.day24.LobbyFloor.Tile.blackTile;
import static net.erchen.adventofcode.day24.LobbyFloor.Tile.whiteTile;
import static org.assertj.core.api.Assertions.assertThat;

class LobbyFloorTest {

    @SneakyThrows
    static List<String> demoInput() {
        return Files.readAllLines(Path.of("src/test/resources/day24/demo.txt"));
    }

    @SneakyThrows
    static List<String> solutionInput() {
        return Files.readAllLines(Path.of("src/test/resources/day24/input.txt"));
    }

    @Test
    void shouldFlipSingleTile() {
        var lobbyFloor = new LobbyFloor();
        lobbyFloor.applyFlippingInstructions(List.of("esew"));

        assertThat(lobbyFloor.getFloor()).hasSize(1).containsEntry(new LobbyFloor.Coordinate(0, 1), blackTile());
    }

    @Test
    void shouldFlipStartingTile() {
        var lobbyFloor = new LobbyFloor();
        lobbyFloor.applyFlippingInstructions(List.of("nwwswee"));

        assertThat(lobbyFloor.getFloor()).hasSize(1).containsEntry(new LobbyFloor.Coordinate(0, 0), blackTile());
    }

    @Test
    void shouldFlipSingleTileTwice() {
        var lobbyFloor = new LobbyFloor();
        lobbyFloor.applyFlippingInstructions(List.of("esew", "esew"));

        assertThat(lobbyFloor.getFloor()).hasSize(1).containsEntry(new LobbyFloor.Coordinate(0, 1), whiteTile());
    }

    @Test
    void shouldCountBlackTiles_Sample() {
        var lobbyFloor = new LobbyFloor();
        lobbyFloor.applyFlippingInstructions(demoInput());

        assertThat(lobbyFloor.countBlackTiles()).isEqualTo(10);
    }

    @Test
    void shouldCountBlackTiles_Solution() {
        var lobbyFloor = new LobbyFloor();
        lobbyFloor.applyFlippingInstructions(solutionInput());

        assertThat(lobbyFloor.countBlackTiles()).isEqualTo(230);
    }

    @Test
    void shouldFlipTiles_Sample() {
        var lobbyFloor = new LobbyFloor();
        lobbyFloor.applyFlippingInstructions(demoInput());

        assertThat(lobbyFloor.countBlackTiles()).isEqualTo(10);
        lobbyFloor.flipDailyTiles();
        assertThat(lobbyFloor.countBlackTiles()).isEqualTo(15);
        lobbyFloor.flipDailyTiles();
        assertThat(lobbyFloor.countBlackTiles()).isEqualTo(12);
        lobbyFloor.flipDailyTiles();
        assertThat(lobbyFloor.countBlackTiles()).isEqualTo(25);
        lobbyFloor.flipDailyTiles();
        assertThat(lobbyFloor.countBlackTiles()).isEqualTo(14);
        lobbyFloor.flipDailyTiles();
        assertThat(lobbyFloor.countBlackTiles()).isEqualTo(23);
        lobbyFloor.flipDailyTiles();
        assertThat(lobbyFloor.countBlackTiles()).isEqualTo(28);
        lobbyFloor.flipDailyTiles();
        assertThat(lobbyFloor.countBlackTiles()).isEqualTo(41);
        lobbyFloor.flipDailyTiles();
        assertThat(lobbyFloor.countBlackTiles()).isEqualTo(37);
        lobbyFloor.flipDailyTiles();
        assertThat(lobbyFloor.countBlackTiles()).isEqualTo(49);
        lobbyFloor.flipDailyTiles();
        assertThat(lobbyFloor.countBlackTiles()).isEqualTo(37);
        lobbyFloor.flipDailyTiles(10);
        assertThat(lobbyFloor.countBlackTiles()).isEqualTo(132);
        lobbyFloor.flipDailyTiles(80);
        assertThat(lobbyFloor.countBlackTiles()).isEqualTo(2208);
    }

    @Test
    void shouldFlipTiles_Solution() {
        var lobbyFloor = new LobbyFloor();
        lobbyFloor.applyFlippingInstructions(solutionInput());

        lobbyFloor.flipDailyTiles(100);
        assertThat(lobbyFloor.countBlackTiles()).isEqualTo(3565);
    }
}