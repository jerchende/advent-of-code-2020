package net.erchen.adventofcode.day20;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.assertj.core.api.Assertions.assertThat;

class PhotoTileTest {

    static String demoInput() throws IOException {
        return Files.readString(Path.of("src/test/resources/day20/demo.txt"));
    }

    @Test
    void fromString() {
        var photoTile = PhotoTile.parseTile("""
                Tile 2311:
                ..##.#..#.
                ##..#.....
                #...##..#.
                ####.#...#
                ##.##.###.
                ##...#.###
                .#.#.#..##
                ..#....#..
                ###...#.#.
                ..###..###
                """);

        assertThat(photoTile.getId()).isEqualTo(2311);
        assertThat(photoTile.getBorders()).containsExactly("0011010010", "0001011001", "1110011100", "0100111110");
    }

    @Test
    void parseAll() throws IOException {
        assertThat(PhotoTile.fromString(demoInput())).hasSize(9);
    }
}