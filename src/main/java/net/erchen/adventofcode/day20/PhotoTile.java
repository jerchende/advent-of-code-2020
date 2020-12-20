package net.erchen.adventofcode.day20;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import net.erchen.adventofcode.common.parser.SeparatorParser;

import java.util.List;

import static java.lang.Integer.parseInt;

@Data
@RequiredArgsConstructor
public class PhotoTile {

    private final int id;
    private final List<String> borders;

    public static List<PhotoTile> fromString(String input) {
        return SeparatorParser.parseInput(input, "\n\n", PhotoTile::parseTile);
    }

    static PhotoTile parseTile(String input) {
        var id = parseInt(input.substring(5, 9));
        var data = input.substring(10).replace('#', '1').replace('.', '0').replaceAll("[^01]", "");

        var top = data.substring(0, 10);
        var right = new String(new char[]{data.charAt(9), data.charAt(19), data.charAt(29), data.charAt(39), data.charAt(49), data.charAt(59), data.charAt(69), data.charAt(79), data.charAt(89), data.charAt(99)});
        var bottom = reverse(data.substring(90));
        var left = new String(new char[]{data.charAt(90), data.charAt(80), data.charAt(70), data.charAt(60), data.charAt(50), data.charAt(40), data.charAt(30), data.charAt(20), data.charAt(10), data.charAt(0)});

        return new PhotoTile(id, List.of(top, right, bottom, left, reverse(top), reverse(right), reverse(bottom), reverse(left)));
    }

    private static String reverse(String str) {
        return new StringBuilder(str).reverse().toString();
    }

    public boolean matchesBorder(String border) {
        return borders.contains(border);
    }

}
