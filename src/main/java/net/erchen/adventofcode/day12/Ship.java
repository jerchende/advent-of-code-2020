package net.erchen.adventofcode.day12;

public interface Ship {

    int getPositionX();

    int getPositionY();

    void applyCommand(Action action, int value);
}
