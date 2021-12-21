package net.erchen.adventofcode.day24;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.util.*;
import java.util.stream.Stream;

public class LobbyFloor {

    @Getter
    private Map<Coordinate, Tile> floor = new HashMap<>();
    private static final Coordinate startingTile = new Coordinate(0, 0);

    public void applyFlippingInstructions(List<String> input) {
        input.stream()
                .map(this::toDirections)
                .map(this::findCoordinate)
                .forEach(coordinate -> floor.computeIfAbsent(coordinate, $ -> new Tile()).flip());
    }

    public void flipDailyTiles(int days) {
        for (int i = 0; i < days; i++) {
            flipDailyTiles();
        }
    }

    public void flipDailyTiles() {
        var flipList = new LinkedList<Coordinate>();

        var xInfo = floor.keySet().stream().mapToInt(Coordinate::getX).summaryStatistics();
        var yInfo = floor.keySet().stream().mapToInt(Coordinate::getY).summaryStatistics();

        for (int x = xInfo.getMin() - 1; x <= xInfo.getMax() + 1; x++) {
            for (int y = yInfo.getMin() - 1; y <= yInfo.getMax() + 1; y++) {
                var current = new Coordinate(x, y);
                var blackAdjacents = adjacents(current).filter(this::isBlack).count();
                var isCurrentBlack = floor.computeIfAbsent(current, $ -> new Tile()).isBlack();

                if (isCurrentBlack && (blackAdjacents == 0 || blackAdjacents > 2)) {
                    flipList.add(current);
                }

                if (!isCurrentBlack && blackAdjacents == 2) {
                    flipList.add(current);
                }
            }
        }
        flipList.forEach(flip -> floor.get(flip).flip());
    }

    private boolean isBlack(Coordinate coordinate) {
        return floor.containsKey(coordinate) && floor.get(coordinate).isBlack();
    }

    public Stream<Coordinate> adjacents(Coordinate coordinate) {
        return Arrays.stream(Direction.values()).map(coordinate::move);
    }

    private Coordinate findCoordinate(List<Direction> directions) {
        Coordinate tile = startingTile;
        for (Direction direction : directions) {
            tile = tile.move(direction);
        }
        return tile;
    }

    private List<Direction> toDirections(String line) {
        var directions = new LinkedList<Direction>();
        for (int i = 0; i < line.length(); i++) {
            directions.add(switch (line.charAt(i)) {
                case 'e' -> Direction.East;
                case 'w' -> Direction.West;
                case 's' -> line.charAt(++i) == 'e' ? Direction.Southeast : Direction.Southwest;
                case 'n' -> line.charAt(++i) == 'e' ? Direction.Northeast : Direction.Northwest;
                default -> throw new IllegalStateException("Unexpected value: " + line.charAt(i));
            });

        }
        return directions;
    }

    public long countBlackTiles() {
        return floor.values().stream().filter(Tile::isBlack).count();
    }

    @Getter
    @ToString
    @RequiredArgsConstructor
    @EqualsAndHashCode
    public static class Coordinate {
        private final int x;
        private final int y;

        public Coordinate move(Direction direction) {
            return new Coordinate(x + direction.moveX, y + direction.moveY);
        }
    }

    @ToString
    @Getter
    @EqualsAndHashCode
    public static class Tile {
        public static Tile blackTile() {
            var tile = new Tile();
            tile.isBlack = true;
            return tile;
        }

        public static Tile whiteTile() {
            return new Tile();
        }

        private boolean isBlack;

        public void flip() {
            isBlack = !isBlack;
        }
    }

    @RequiredArgsConstructor
    public enum Direction {
        East(1, 0),
        Southeast(0, 1),
        Southwest(-1, +1),
        West(-1, 0),
        Northwest(0, -1),
        Northeast(1, -1);

        private final int moveX;
        private final int moveY;
    }

}
