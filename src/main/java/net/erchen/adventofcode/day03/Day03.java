package net.erchen.adventofcode.day03;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Day03 {

    public static long part1(List<String> wood) {
        return countTrees(wood, 3, 1);
    }

    public static long part2(List<String> wood) {
        return countTrees(wood, 1, 1)
                * countTrees(wood, 3, 1)
                * countTrees(wood, 5, 1)
                * countTrees(wood, 7, 1)
                * countTrees(wood, 1, 2);

    }

    public static long countTrees(List<String> wood, int moveRight, int moveDown) {
        AtomicInteger top = new AtomicInteger(0);
        AtomicInteger left = new AtomicInteger(0);
        final int lineLength = wood.get(0).length();

        return wood.stream()
                .filter((line) -> top.getAndAdd(1) % moveDown == 0)
                .mapToInt(woodline -> {
                    var isATree = woodline.charAt(left.intValue()) == '#';
                    moveCursorRight(left, lineLength, moveRight);
                    return isATree ? 1 : 0;
                }).sum();
    }

    private static void moveCursorRight(AtomicInteger left, int lineLength, int fields) {
        if (left.addAndGet(fields) >= lineLength) {
            left.addAndGet(-lineLength);
        }
    }
}
