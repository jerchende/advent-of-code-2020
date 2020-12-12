package net.erchen.adventofcode.day12;

import java.util.List;

import static java.lang.Integer.parseInt;
import static java.lang.Math.abs;
import static net.erchen.adventofcode.day12.Action.fromRepresentation;

public class ShipNavigator {

    public static int calculateDistancePart1(List<String> inputs) {
        return calculateManhattenDistance(applyCommandsToShip(inputs, new ShipPart1()));
    }

    public static int calculateDistancePart2(List<String> inputs) {
        return calculateManhattenDistance(applyCommandsToShip(inputs, new ShipPart2()));
    }

    private static Ship applyCommandsToShip(List<String> inputs, Ship ship) {
        inputs.forEach(command -> ship.applyCommand(fromRepresentation(command.charAt(0)), parseInt(command.substring(1))));
        return ship;
    }

    private static int calculateManhattenDistance(Ship ship) {
        return abs(ship.getPositionX()) + abs(ship.getPositionY());
    }
}
