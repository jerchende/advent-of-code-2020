package net.erchen.adventofcode.day12;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ActionTest {

    @Test
    void fromRepresentation() {
        assertThat(Action.fromRepresentation('N')).isEqualTo(Action.MOVE_TO_NORTH);
        assertThat(Action.fromRepresentation('S')).isEqualTo(Action.MOVE_TO_SOUTH);
        assertThat(Action.fromRepresentation('E')).isEqualTo(Action.MOVE_TO_EAST);
        assertThat(Action.fromRepresentation('W')).isEqualTo(Action.MOVE_TO_WEST);
        assertThat(Action.fromRepresentation('L')).isEqualTo(Action.TURN_LEFT);
        assertThat(Action.fromRepresentation('R')).isEqualTo(Action.TURN_RIGHT);
        assertThat(Action.fromRepresentation('F')).isEqualTo(Action.FORWARD);
    }

    @Test
    void fromDirection() {
        assertThat(Action.fromDirection(0)).isEqualTo(Action.MOVE_TO_NORTH);
        assertThat(Action.fromDirection(180)).isEqualTo(Action.MOVE_TO_SOUTH);
        assertThat(Action.fromDirection(90)).isEqualTo(Action.MOVE_TO_EAST);
        assertThat(Action.fromDirection(270)).isEqualTo(Action.MOVE_TO_WEST);
        assertThrows(IllegalArgumentException.class, () -> Action.fromDirection(99));
    }
}