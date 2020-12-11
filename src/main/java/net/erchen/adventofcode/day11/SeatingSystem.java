package net.erchen.adventofcode.day11;

import lombok.*;

import java.util.List;

import static java.util.Arrays.deepEquals;


@Data
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class SeatingSystem {

    @Getter
    @RequiredArgsConstructor
    public enum SeatingAlgorithm {
        Part1(4), Part2(5);

        private final int maxOccupied;
    }

    private final static int[][] Directions = new int[][]{
            {-1, -1},
            {0, -1},
            {1, -1},

            {-1, 0},
            {1, 0},

            {-1, 1},
            {0, 1},
            {1, 1},
    };

    public final static char Floor = '.';
    public final static char Empty = 'L';
    public final static char Occupied = '#';

    private char[][] seats;
    private final SeatingAlgorithm seatingAlgorithm;

    public static SeatingSystem fromInput(List<String> input, SeatingAlgorithm seatingAlgorithm) {
        var seats = input.stream().map(String::toCharArray).toArray(char[][]::new);
        return new SeatingSystem(seats, seatingAlgorithm);
    }

    public void applySeatingRulesUntilChaosIsStabilized() {
        while (applySeatingRules()) {
        }
    }

    public int countOccupiedSeats() {
        int counter = 0;
        for (int y = 0; y < seats.length; y++) {
            for (int x = 0; x < seats[y].length; x++) {
                if (seats[y][x] == Occupied) {
                    counter++;
                }
            }
        }
        return counter;
    }

    boolean applySeatingRules() {
        char[][] newSeats = new char[seats.length][seats[0].length];

        for (int y = 0; y < seats.length; y++) {
            for (int x = 0; x < seats[y].length; x++) {
                newSeats[y][x] = applySeatingRules(y, x);
            }
        }
        if (deepEquals(newSeats, seats)) {
            return false;
        }
        seats = newSeats;
        return true;
    }

    private char applySeatingRules(int y, int x) {
        return switch (seats[y][x]) {
            case Floor -> Floor;
            case Empty -> getOccupiedSeatsAdjacent(y, x) == 0 ? Occupied : Empty;
            case Occupied -> getOccupiedSeatsAdjacent(y, x) >= seatingAlgorithm.getMaxOccupied() ? Empty : Occupied;
            default -> throw new UnsupportedOperationException();
        };
    }

    char[] getSeatsAdjacent(int onY, int onX) {
        char[] seatsAdjacent = new char[9];
        int i = 0;

        for (int[] direction : Directions) {
            char seat = '0';

            int y = onY;
            int x = onX;

            do {
                y += direction[0];
                x += direction[1];
                if (y < 0 || y >= seats.length || x < 0 || x >= seats[y].length) {
                    break;
                }
                seat = seats[y][x];
            } while (seatingAlgorithm == SeatingAlgorithm.Part2 && seat == Floor);
            if (seat != '0') {
                seatsAdjacent[i++] = seat;
            }

        }
        return seatsAdjacent;
    }

    int getOccupiedSeatsAdjacent(int onY, int onX) {
        int occupiedCounter = 0;
        for (char seat : getSeatsAdjacent(onY, onX)) {
            if (seat == Occupied) {
                occupiedCounter++;
            }
        }
        return occupiedCounter;
    }
}