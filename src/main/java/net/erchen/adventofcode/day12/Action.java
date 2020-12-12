package net.erchen.adventofcode.day12;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.stream.Stream;

@Getter
@RequiredArgsConstructor
public enum Action {
    MOVE_TO_NORTH('N', 0, -1, 0, 0),
    MOVE_TO_SOUTH('S', 0, 1, 0, 180),
    MOVE_TO_EAST('E', 1, 0, 0, 90),
    MOVE_TO_WEST('W', -1, 0, 0, 270),
    TURN_LEFT('L', 0, 0, -1, -1),
    TURN_RIGHT('R', 0, 0, 1, -1),
    FORWARD('F', 0, 0, 0, -1);

    private final char representation;
    private final int mutliplicatorX;
    private final int mutliplicatorY;
    private final int mutliplicatorDirection;
    private final int direction;

    public static Action fromRepresentation(char representation) {
        return Stream.of(Action.values()).filter(action -> action.representation == representation).findFirst().orElseThrow();
    }

    public static Action fromDirection(int direction) {
        return Stream.of(Action.values()).filter(action -> action.direction == direction).findFirst().orElseThrow(() -> new IllegalArgumentException("Unknown Direction: " + direction));
    }
}
