package net.erchen.adventofcode.day20;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.assertj.core.api.Assertions.assertThat;

class PhotoTileTest {

    static final String singleTile = """
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
            """;

    static final Border borderTop = Border.fromString("..##.#..#.");
    static final Border borderRight = Border.fromString("...#.##..#");
    static final Border borderBottom = Border.fromString("###..###..");
    static final Border borderLeft = Border.fromString(".#..#####.");

    static String demoInput() throws IOException {
        return Files.readString(Path.of("src/test/resources/day20/demo.txt"));
    }

    @Test
    void fromString() {
        var photoTile = PhotoTile.parseTile(singleTile);

        assertThat(photoTile.getId()).isEqualTo(new PhotoTileId(2311));
        assertThat(photoTile.getBorders()).containsExactly(borderTop, borderRight, borderBottom, borderLeft);
        assertThat(photoTile.getFlippedBorders()).containsExactly(borderTop.flipBorder(), borderRight.flipBorder(), borderBottom.flipBorder(), borderLeft.flipBorder());

        assertThat(photoTile.getContent()).isDeepEqualTo(new boolean[][]{
                {true, false, false, true, false, false, false, false},
                {false, false, false, true, true, false, false, true},
                {true, true, true, false, true, false, false, false},
                {true, false, true, true, false, true, true, true},
                {true, false, false, false, true, false, true, true},
                {true, false, true, false, true, false, false, true},
                {false, true, false, false, false, false, true, false},
                {true, true, false, false, false, true, false, true}});
    }

    @Test
    void parseAll() throws IOException {
        assertThat(PhotoTile.fromString(demoInput())).hasSize(9);
    }

    @Test
    void shouldRotate() {
        var photoTile = PhotoTile.parseTile(singleTile);
        assertThat(photoTile.getBorders()).containsExactly(borderTop, borderRight, borderBottom, borderLeft);
        assertThat(photoTile.getFlippedBorders()).containsExactly(borderTop.flipBorder(), borderRight.flipBorder(), borderBottom.flipBorder(), borderLeft.flipBorder());

        photoTile.rotate();
        photoTile.rotate();

        var rotated = PhotoTile.parseTile("""
                Tile 2311:
                ###..###..
                .#.#...###
                ..#....#..
                ##..#.#.#.
                ###.#...##
                .###.##.##
                #...#.####
                .#..##...#
                .....#..##
                .#..#.##..
                """);
        assertThat(photoTile.getBorders()).containsExactlyElementsOf(rotated.getBorders());
        assertThat(photoTile.getContent()).isDeepEqualTo(rotated.getContent());
    }

    @Test
    void shouldFlip() {
        var photoTile = PhotoTile.parseTile(singleTile);

        photoTile.flip();

        var flipped = PhotoTile.parseTile("""
                Tile 2311:
                ..###..###
                ###...#.#.
                ..#....#..
                .#.#.#..##
                ##...#.###
                ##.##.###.
                ####.#...#
                #...##..#.
                ##..#.....
                ..##.#..#.
                """);
        assertThat(photoTile.getBorders()).containsExactlyElementsOf(flipped.getBorders());
        assertThat(photoTile.getContent()).isDeepEqualTo(flipped.getContent());
    }
}