package net.erchen.adventofcode.day20;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Path;

import static org.assertj.core.api.Assertions.assertThat;

class ImageProcessorTest {

    static final boolean[][] expectedImage = {
            {false, true, false, true, false, false, true, false, true, true, false, false, false, true, false, true, true, false, false, true, true, true, true, true},
            {true, true, true, false, false, false, false, true, false, true, false, false, false, false, true, false, false, true, false, false, false, false, false, false},
            {true, true, false, true, true, false, true, true, true, false, true, false, true, false, false, true, true, true, true, true, true, false, false, false},
            {true, true, true, false, true, true, true, true, true, false, false, false, true, false, true, true, true, true, true, false, true, false, false, true},
            {true, true, false, true, false, false, false, false, true, false, true, true, false, true, true, true, true, false, false, false, true, false, true, true},
            {false, false, false, true, true, true, true, true, true, true, true, false, true, false, false, false, false, true, true, true, true, true, false, true},
            {false, false, false, false, true, false, false, true, false, false, false, true, true, false, false, true, false, true, false, true, true, true, false, false},
            {false, true, true, true, true, false, false, false, true, false, false, true, false, false, false, false, false, true, false, false, false, false, false, false},
            {true, false, false, true, false, true, true, false, false, true, false, false, true, true, true, false, true, false, true, true, false, false, false, false},
            {true, false, true, true, true, true, false, false, true, false, true, true, true, true, false, true, false, true, false, true, true, true, false, false},
            {true, true, true, false, true, false, true, false, false, false, true, false, true, true, true, true, true, true, false, true, false, false, true, true},
            {true, false, true, true, true, true, false, false, false, false, true, true, false, false, true, true, true, true, true, true, true, true, false, true},
            {true, true, false, false, true, true, false, true, false, false, false, true, false, false, false, true, false, true, false, true, false, true, false, false},
            {false, false, false, true, false, false, true, false, false, true, false, true, false, true, true, false, false, true, true, true, false, true, true, true},
            {false, true, false, true, false, false, false, false, true, false, true, true, false, true, false, false, false, true, true, true, false, true, true, false},
            {true, true, true, false, true, false, false, false, true, false, false, true, false, true, true, false, true, true, true, true, true, true, false, false},
            {false, true, false, true, false, true, true, true, false, true, true, false, true, true, false, true, false, false, true, false, true, true, false, false},
            {false, true, true, true, true, false, true, true, true, false, true, false, false, false, true, true, true, false, true, false, false, true, false, true},
            {false, false, true, false, true, false, false, true, false, false, true, false, true, false, true, false, true, true, true, true, false, true, true, true},
            {true, false, false, true, true, true, true, false, false, false, true, false, true, false, true, false, true, true, true, false, true, true, true, false},
            {true, true, true, true, true, false, false, true, true, true, true, true, false, false, false, true, true, true, false, false, false, false, true, true},
            {true, false, true, true, false, false, true, false, false, true, false, false, false, true, false, false, true, true, true, true, false, false, false, true},
            {false, true, false, true, true, true, false, false, true, true, false, false, true, true, false, false, true, true, true, true, false, true, true, false},
            {false, false, false, true, true, true, false, false, false, true, true, false, false, false, true, false, false, false, true, false, false, true, true, true},
    };

    @SneakyThrows
    static String demoInput() {
        return Files.readString(Path.of("src/test/resources/day20/demo.txt"));
    }

    @SneakyThrows
    static String solutionInput() {
        return Files.readString(Path.of("src/test/resources/day20/input.txt"));
    }

    ImageProcessor demo = new ImageProcessor(demoInput());
    ImageProcessor solution = new ImageProcessor(solutionInput());


    @Test
    void getEdgeMultipliedDemo() {
        assertThat(demo.edgeProduct()).isEqualTo(20899048083289L);
    }

    @Test
    void getEdgeMultipliedSolution() {
        assertThat(solution.edgeProduct()).isEqualTo(18262194216271L);
    }

    @Test
    void shouldArrangeTiles_Demo() {
        var image = demo.arrangeTiles();

        assertThat(image).hasDimensions(3, 3);

        assertThat(image[0][0].getId()).isEqualTo(new PhotoTileId(1951));
        assertThat(image[0][1].getId()).isEqualTo(new PhotoTileId(2311));
        assertThat(image[0][2].getId()).isEqualTo(new PhotoTileId(3079));

        assertThat(image[1][0].getId()).isEqualTo(new PhotoTileId(2729));
        assertThat(image[1][1].getId()).isEqualTo(new PhotoTileId(1427));
        assertThat(image[1][2].getId()).isEqualTo(new PhotoTileId(2473));

        assertThat(image[2][0].getId()).isEqualTo(new PhotoTileId(2971));
        assertThat(image[2][1].getId()).isEqualTo(new PhotoTileId(1489));
        assertThat(image[2][2].getId()).isEqualTo(new PhotoTileId(1171));

        assertThat(image[0][0].getBorders().get(0)).isEqualTo(Border.fromString("#...##.#.."));
        assertThat(image[0][1].getBorders().get(0)).isEqualTo(Border.fromString("..###..###"));
        assertThat(image[0][2].getBorders().get(0)).isEqualTo(Border.fromString("#.#.#####."));

        assertThat(image[1][0].getBorders().get(0)).isEqualTo(Border.fromString("#.##...##."));
        assertThat(image[1][1].getBorders().get(0)).isEqualTo(Border.fromString("..##.#..#."));
        assertThat(image[1][2].getBorders().get(0)).isEqualTo(Border.fromString("..#.###..."));
    }

    @Test
    void shouldArrangeTiles_Solution() {
        var image = solution.arrangeTiles();

        assertThat(image).hasDimensions(12, 12);
    }

    @Test
    void assembleImage_Demo() {
        var image = demo.assembleImage();

        assertThat(image).isEqualTo(expectedImage);
    }

    @Test
    void countSeaMonsters() {
        assertThat(ImageProcessor.countSeaMonsters(expectedImage)).isEqualTo(2);
    }

    @Test
    void waterRoughness_Demo() {
        assertThat(demo.waterRoughness()).isEqualTo(273);
    }

    @Test
    void waterRoughness_Solution() {
        assertThat(solution.waterRoughness()).isEqualTo(2023);
    }
}