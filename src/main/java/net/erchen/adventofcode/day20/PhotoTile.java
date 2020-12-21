package net.erchen.adventofcode.day20;

import lombok.Data;
import net.erchen.adventofcode.common.parser.SeparatorParser;

import java.util.List;

import static java.lang.Integer.parseInt;
import static java.util.stream.Collectors.toList;

@Data
public class PhotoTile {

    public static final int tileDimension = 10;
    public static final int contentDimension = tileDimension - 2;

    private final PhotoTileId id;
    private List<Border> borders;
    private List<Border> flippedBorders;
    private boolean[][] content;

    public PhotoTile(PhotoTileId id, List<Border> borders, boolean[][] content) {
        this.id = id;
        this.borders = borders;
        this.flippedBorders = flipBorders(borders);
        this.content = content;
    }

    private static List<Border> flipBorders(List<Border> borders) {
        return borders.stream().map(Border::flipBorder).collect(toList());
    }

    public static List<PhotoTile> fromString(String input) {
        return SeparatorParser.parseInput(input, "\n\n", PhotoTile::parseTile);
    }

    static PhotoTile parseTile(String input) {
        var id = new PhotoTileId(parseInt(input.substring(5, 9)));
        var data = input.substring(10).replaceAll("[^.#]", "");

        var top = Border.fromString(data.substring(0, 10));
        var right = Border.fromString(new String(new char[]{data.charAt(9), data.charAt(19), data.charAt(29), data.charAt(39), data.charAt(49), data.charAt(59), data.charAt(69), data.charAt(79), data.charAt(89), data.charAt(99)}));
        var bottom = Border.fromString(data.substring(90)).flipBorder();
        var left = Border.fromString(new String(new char[]{data.charAt(90), data.charAt(80), data.charAt(70), data.charAt(60), data.charAt(50), data.charAt(40), data.charAt(30), data.charAt(20), data.charAt(10), data.charAt(0)}));

        return new PhotoTile(id, List.of(top, right, bottom, left), parseContent(data));
    }

    private static boolean[][] parseContent(String data) {
        boolean[][] content = new boolean[contentDimension][contentDimension];
        for (int y = 1; y <= contentDimension; y++) {
            for (int x = 1; x <= contentDimension; x++) {
                content[y - 1][x - 1] = data.charAt(y * tileDimension + x) == '#';
            }
        }
        return content;
    }

    public boolean matchesInAnyDirection(Border border) {
        return borders.contains(border) || flippedBorders.contains(border);
    }

    public void rotate() {
        borders = List.of(borders.get(3), borders.get(0), borders.get(1), borders.get(2));
        flippedBorders = flipBorders(borders);
        rotateContent();
    }

    private void rotateContent() {
        boolean[][] rotated = new boolean[contentDimension][contentDimension];
        ArrayHelper.rotate(content, rotated);
        content = rotated;
    }

    public void flip() {
        flippedBorders = List.of(borders.get(2), borders.get(1), borders.get(0), borders.get(3));
        borders = flipBorders(flippedBorders);
        flipContent();
    }

    private void flipContent() {
        boolean[][] flipped = new boolean[contentDimension][contentDimension];
        ArrayHelper.flip(content, flipped);
        content = flipped;
    }

    public void verticalFlip() {
        rotate();
        flip();
        rotate();
        rotate();
        rotate();
    }

    public PhotoTile transformMatchingTo(Border matchingBorder, int position) {
        while (!borders.get(position).equals(matchingBorder)) {
            if (borders.contains(matchingBorder)) {
                rotate();
            } else if (flippedBorders.contains(matchingBorder)) {
                flip();
                rotate();
            } else {
                throw new RuntimeException("Not matching");
            }
        }
        return this;
    }
}
