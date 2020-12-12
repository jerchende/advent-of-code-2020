package net.erchen.adventofcode.day12;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ShipPart2Test {

    @Test
    void shouldMoveWest() {
        var ship = new ShipPart2();

        ship.applyCommand(Action.MOVE_TO_WEST, 5);

        assertThat(ship.getPositionX()).isEqualTo(0);
        assertThat(ship.getPositionY()).isEqualTo(0);
        assertThat(ship.getWaypointX()).isEqualTo(5);
        assertThat(ship.getWaypointY()).isEqualTo(-1);
    }

    @Test
    void shouldMoveEast() {
        var ship = new ShipPart2();

        ship.applyCommand(Action.MOVE_TO_EAST, 5);

        assertThat(ship.getPositionX()).isEqualTo(0);
        assertThat(ship.getPositionY()).isEqualTo(0);
        assertThat(ship.getWaypointX()).isEqualTo(15);
        assertThat(ship.getWaypointY()).isEqualTo(-1);
    }

    @Test
    void shouldMoveNorth() {
        var ship = new ShipPart2();

        ship.applyCommand(Action.MOVE_TO_NORTH, 5);

        assertThat(ship.getPositionX()).isEqualTo(0);
        assertThat(ship.getPositionY()).isEqualTo(0);
        assertThat(ship.getWaypointX()).isEqualTo(10);
        assertThat(ship.getWaypointY()).isEqualTo(-6);
    }

    @Test
    void shouldMoveSouth() {
        var ship = new ShipPart2();

        ship.applyCommand(Action.MOVE_TO_SOUTH, 5);

        assertThat(ship.getPositionX()).isEqualTo(0);
        assertThat(ship.getPositionY()).isEqualTo(0);
        assertThat(ship.getWaypointX()).isEqualTo(10);
        assertThat(ship.getWaypointY()).isEqualTo(4);
    }


    @Test
    void shouldTurnLeft() {
        var ship = new ShipPart2();

        ship.applyCommand(Action.TURN_LEFT, 90);

        assertThat(ship.getPositionX()).isEqualTo(0);
        assertThat(ship.getPositionY()).isEqualTo(0);
        assertThat(ship.getWaypointX()).isEqualTo(-1);
        assertThat(ship.getWaypointY()).isEqualTo(-10);
    }

    @Test
    void shouldTurnRight() {
        var ship = new ShipPart2();

        ship.applyCommand(Action.TURN_RIGHT, 90);

        assertThat(ship.getPositionX()).isEqualTo(0);
        assertThat(ship.getPositionY()).isEqualTo(0);
        assertThat(ship.getWaypointX()).isEqualTo(1);
        assertThat(ship.getWaypointY()).isEqualTo(10);
    }

    @Test
    void shouldTurn180() {
        var ship = new ShipPart2();

        ship.applyCommand(Action.TURN_RIGHT, 180);

        assertThat(ship.getPositionX()).isEqualTo(0);
        assertThat(ship.getPositionY()).isEqualTo(0);
        assertThat(ship.getWaypointX()).isEqualTo(-10);
        assertThat(ship.getWaypointY()).isEqualTo(1);
    }

    @Test
    void shouldMoveForward() {
        var ship = new ShipPart2();

        ship.applyCommand(Action.FORWARD, 5);

        assertThat(ship.getPositionX()).isEqualTo(50);
        assertThat(ship.getPositionY()).isEqualTo(-5);
        assertThat(ship.getWaypointX()).isEqualTo(10);
        assertThat(ship.getWaypointY()).isEqualTo(-1);
    }

}