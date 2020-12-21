package net.erchen.adventofcode.day20;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;
import static net.erchen.adventofcode.day20.PhotoTile.contentDimension;

public class ImageProcessor {

    private final List<PhotoTile> tiles;
    private final int dimension;

    public ImageProcessor(String input) {
        this.tiles = PhotoTile.fromString(input);
        this.dimension = (int) Math.sqrt(this.tiles.size());
    }

    public long edgeProduct() {
        return edges().map(PhotoTile::getId).mapToLong(PhotoTileId::id).reduce(1L, (a, b) -> a * b);
    }

    private Stream<PhotoTile> edges() {
        return tiles.stream().filter(tile -> anyMatchingBorders(tile) == 2);
    }

    public int anyMatchingBorders(PhotoTile tile) {
        return (int) IntStream.range(0, 4).filter(i -> hasAnyMatchingBorderOnPosition(tile, i)).count();
    }

    public int matchingBorders(PhotoTile tile) {
        return (int) IntStream.range(0, 4).filter(i -> hasMatchingBorderOnPosition(tile, i)).count();
    }

    private boolean hasAnyMatchingBorderOnPosition(PhotoTile tile, int position) {
        return tiles.stream().filter(t -> t != tile).anyMatch(t -> t.matchesInAnyDirection(tile.getBorders().get(position)));
    }

    private boolean hasMatchingBorderOnPosition(PhotoTile tile, int position) {
        return tiles.stream().filter(t -> t != tile).anyMatch(t -> t.getBorders().contains(tile.getBorders().get(position)));
    }

    private PhotoTile findMatchingTile(Border matchingBorder, int position, List<PhotoTile> excludedTiles) {
        return tiles.stream()
                .filter(tile -> !excludedTiles.contains(tile))
                .filter(tile -> tile.matchesInAnyDirection(matchingBorder))
                .findFirst().orElseThrow()
                .transformMatchingTo(matchingBorder, position);
    }

    public PhotoTile[][] arrangeTiles() {
        PhotoTile[][] image = new PhotoTile[dimension][dimension];

        var startingTile = edges().findFirst().orElseThrow();

        while (matchingBorders(startingTile) == 0) {
            startingTile.flip();
        }
        while (hasMatchingBorderOnPosition(startingTile, 0) || hasMatchingBorderOnPosition(startingTile, 3)) {
            startingTile.rotate();
        }

        image[0][0] = startingTile;
        var lastTile = startingTile;

        int lookPosition = 3;
        for (int y = 0; y < dimension; y++) {
            for (int x = 0; x < dimension; x++) {
                if (x == 0 && y == 0) {
                    continue;
                }
                try {
                    lastTile = findMatchingTile(lastTile.getBorders().get((lookPosition + 2) % 4), lookPosition, Stream.of(image).flatMap(Stream::of).collect(toList()));
                } catch (NoSuchElementException e) {
                    if (x == 1) {
                        lastTile.verticalFlip();
                        lastTile = findMatchingTile(lastTile.getBorders().get((lookPosition + 2) % 4), lookPosition, Stream.of(image).flatMap(Stream::of).collect(toList()));
                    } else {
                        throw new RuntimeException("Not solvable, sorry");
                    }
                }

                if (y == 0 && !hasAnyMatchingBorderOnPosition(lastTile, 2) || (x > 0 && !image[y - 1][x].getBorders().get(2).equals(lastTile.getBorders().get(1)))) {
                    lastTile.flip();
                }

                image[y][x] = lastTile;

                lookPosition = 3;
            }
            lookPosition = 0;
            lastTile = image[y][0];
        }

        return image;
    }

    public boolean[][] assembleImage() {
        var tiles = arrangeTiles();
        var image = new boolean[dimension * contentDimension][dimension * contentDimension];

        for (int y = 0; y < dimension * contentDimension; y++) {
            for (int x = 0; x < dimension * contentDimension; x++) {
                image[y][x] = tiles[y / contentDimension][x / contentDimension].getContent()[y % contentDimension][x % contentDimension];
            }
        }

        return image;
    }

    public static int countSeaMonsters(boolean[][] image) {
        for (int m = 0; m < 20; m++) {
            if (m % 5 == 0) {
                image = ArrayHelper.flip(image, new boolean[image.length][image.length]);
            }
            image = ArrayHelper.rotate(image, new boolean[image.length][image.length]);

            int count = 0;
            for (int y = 1; y <= image.length - 1; y++) {
                for (int x = 0; x <= image[0].length - 20; x++) {
                    /*
                     * ..................#.
                     * #....##....##....###
                     * .#..#..#..#..#..#...
                     */
                    if ((image[y - 1][x + 18])
                            && (image[y][x] && image[y][x + 5] && image[y][x + 6] && image[y][x + 11] && image[y][x + 12] && image[y][x + 17] && image[y][x + 18] && image[y][x + 19])
                            && (image[y + 1][x + 1] && image[y + 1][x + 4] && image[y + 1][x + 7] && image[y + 1][x + 10] && image[y + 1][x + 13] && image[y + 1][x + 16])) {
                        count++;
                    }
                }
            }
            if (count > 0) {
                return count;
            }
        }
        return -1;
    }

    public int waterRoughness() {
        var image = assembleImage();

        return countWater(image) - countSeaMonsters(image) * 15;
    }

    private static int countWater(boolean[][] image) {
        int waterCount = 0;

        for (boolean[] line : image) {
            for (boolean cell : line) {
                if (cell) {
                    waterCount++;
                }
            }

        }
        return waterCount;
    }
}
