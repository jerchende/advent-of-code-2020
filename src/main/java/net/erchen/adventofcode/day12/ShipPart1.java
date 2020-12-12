package net.erchen.adventofcode.day12;


import lombok.Getter;

@Getter
public class ShipPart1 implements Ship {

    private int directionDegrees = 90;

    private int positionX = 0;

    private int positionY = 0;

    public void applyCommand(Action action, int value) {
        if (action == Action.FORWARD) {
            action = Action.fromDirection(directionDegrees);
        }
        this.positionX += value * action.getMutliplicatorX();
        this.positionY += value * action.getMutliplicatorY();
        this.directionDegrees = normalizeDirection(this.directionDegrees + value * action.getMutliplicatorDirection());
    }

    private int normalizeDirection(int directionDegrees) {
        directionDegrees %= 360;
        return directionDegrees < 0 ? 360 + directionDegrees : directionDegrees;
    }

}
