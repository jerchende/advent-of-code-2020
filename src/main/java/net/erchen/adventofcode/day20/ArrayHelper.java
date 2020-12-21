package net.erchen.adventofcode.day20;

public class ArrayHelper {

    public static boolean[][] rotate(boolean[][] input, boolean[][] rotated) {
        int dimension = input.length;

        for (int y = 0; y < dimension; y++) {
            for (int x = 0; x < dimension; x++) {
                rotated[y][x] = input[dimension - x - 1][y];
            }
        }
        return rotated;
    }


    public static boolean[][] flip(boolean[][] input, boolean[][] flipped) {
        int dimension = input.length;

        for (int y = 0; y < dimension; y++) {
            flipped[y] = input[dimension - 1 - y];
        }
        return flipped;
    }
}
