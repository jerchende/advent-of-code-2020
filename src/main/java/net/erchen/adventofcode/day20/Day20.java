package net.erchen.adventofcode.day20;

import java.util.List;
import java.util.stream.IntStream;

public class Day20 {

    private final List<PhotoTile> tiles;

    public Day20(String input) {
        this.tiles = PhotoTile.fromString(input);
    }

    public long getEdgeProduct() {
        return tiles.stream().filter(tile -> matchingBorders(tile) == 2).mapToLong(PhotoTile::getId).reduce(1L, (a, b) -> a * b);
    }

    public int matchingBorders(PhotoTile tile) {
        return (int) IntStream.range(0, 4).filter(i -> tiles.stream().filter(t -> t != tile).anyMatch(t -> t.matchesBorder(tile.getBorders().get(i)))).count();
    }
}
