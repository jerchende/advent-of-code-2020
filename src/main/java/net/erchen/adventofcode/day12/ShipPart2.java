package net.erchen.adventofcode.day12;


import lombok.Getter;

import static java.lang.Math.*;

@Getter
public class ShipPart2 implements Ship {


    private int positionX = 0;
    private int positionY = 0;

    private int waypointX = 10;
    private int waypointY = -1;

    public void applyCommand(Action action, int value) {
        switch (action) {
            case FORWARD -> {
                positionX += value * waypointX;
                positionY += value * waypointY;
            }
            case TURN_LEFT, TURN_RIGHT -> rotateWaypoint(value * action.getMutliplicatorDirection());
            default -> {
                this.waypointX += value * action.getMutliplicatorX();
                this.waypointY += value * action.getMutliplicatorY();
            }
        }
    }

    private void rotateWaypoint(int degrees) {
        // since the degrees are always multiple of 90°, int values are exact enough. (otherwise there will be rounding differences)
        int sin = (int) sin(toRadians(degrees));
        int cos = (int) cos(toRadians(degrees));

        int x = waypointX;
        int y = waypointY;

        this.waypointX = x * cos - y * sin;
        this.waypointY = x * sin + y * cos;
    }

}
