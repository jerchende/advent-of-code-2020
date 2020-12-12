package net.erchen.adventofcode.day12;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ShipPart1Test {

    @Test
    void shouldMoveWest() {
        var ship = new ShipPart1();

        ship.applyCommand(Action.MOVE_TO_WEST, 5);

        assertThat(ship.getPositionX()).isEqualTo(-5);
        assertThat(ship.getPositionY()).isEqualTo(0);
        assertThat(ship.getDirectionDegrees()).isEqualTo(90);
    }

    @Test
    void shouldMoveEast() {
        var ship = new ShipPart1();

        ship.applyCommand(Action.MOVE_TO_EAST, 5);

        assertThat(ship.getPositionX()).isEqualTo(5);
        assertThat(ship.getPositionY()).isEqualTo(0);
        assertThat(ship.getDirectionDegrees()).isEqualTo(90);
    }

    @Test
    void shouldMoveNorth() {
        var ship = new ShipPart1();

        ship.applyCommand(Action.MOVE_TO_NORTH, 5);

        assertThat(ship.getPositionX()).isEqualTo(0);
        assertThat(ship.getPositionY()).isEqualTo(-5);
        assertThat(ship.getDirectionDegrees()).isEqualTo(90);
    }

    @Test
    void shouldMoveSouth() {
        var ship = new ShipPart1();

        ship.applyCommand(Action.MOVE_TO_SOUTH, 5);

        assertThat(ship.getPositionX()).isEqualTo(0);
        assertThat(ship.getPositionY()).isEqualTo(5);
        assertThat(ship.getDirectionDegrees()).isEqualTo(90);
    }

    @Test
    void shouldTurnLeft() {
        var ship = new ShipPart1();

        ship.applyCommand(Action.TURN_LEFT, 90);

        assertThat(ship.getPositionX()).isEqualTo(0);
        assertThat(ship.getPositionY()).isEqualTo(0);
        assertThat(ship.getDirectionDegrees()).isEqualTo(0);
    }

    @Test
    void shouldTurnRight() {
        var ship = new ShipPart1();

        ship.applyCommand(Action.TURN_RIGHT, 90);

        assertThat(ship.getPositionX()).isEqualTo(0);
        assertThat(ship.getPositionY()).isEqualTo(0);
        assertThat(ship.getDirectionDegrees()).isEqualTo(180);
    }

    @Test
    void shouldNormalizeDirection() {
        var ship = new ShipPart1();

        ship.applyCommand(Action.TURN_RIGHT, 360);

        assertThat(ship.getPositionX()).isEqualTo(0);
        assertThat(ship.getPositionY()).isEqualTo(0);
        assertThat(ship.getDirectionDegrees()).isEqualTo(90);
    }

    @Test
    void shouldNormalizeDirection2() {
        var ship = new ShipPart1();

        ship.applyCommand(Action.TURN_RIGHT, 270);

        assertThat(ship.getPositionX()).isEqualTo(0);
        assertThat(ship.getPositionY()).isEqualTo(0);
        assertThat(ship.getDirectionDegrees()).isEqualTo(0);
    }

    @Test
    void shouldNormalizeDirection3() {
        var ship = new ShipPart1();

        ship.applyCommand(Action.TURN_LEFT, 180);

        assertThat(ship.getPositionX()).isEqualTo(0);
        assertThat(ship.getPositionY()).isEqualTo(0);
        assertThat(ship.getDirectionDegrees()).isEqualTo(270);
    }

    @Test
    void shouldNormalizeDirection4() {
        var ship = new ShipPart1();

        ship.applyCommand(Action.TURN_LEFT, 270);

        assertThat(ship.getPositionX()).isEqualTo(0);
        assertThat(ship.getPositionY()).isEqualTo(0);
        assertThat(ship.getDirectionDegrees()).isEqualTo(180);
    }

    @Test
    void shouldMoveForward() {
        var ship = new ShipPart1();

        ship.applyCommand(Action.FORWARD, 5);

        assertThat(ship.getPositionX()).isEqualTo(5);
        assertThat(ship.getPositionY()).isEqualTo(0);
        assertThat(ship.getDirectionDegrees()).isEqualTo(90);
    }

    @Test
    void shouldTurnAndMoveForward() {
        var ship = new ShipPart1();

        ship.applyCommand(Action.TURN_RIGHT, 90);
        ship.applyCommand(Action.FORWARD, 5);

        assertThat(ship.getPositionX()).isEqualTo(0);
        assertThat(ship.getPositionY()).isEqualTo(5);
        assertThat(ship.getDirectionDegrees()).isEqualTo(180);
    }
}