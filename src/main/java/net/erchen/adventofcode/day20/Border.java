package net.erchen.adventofcode.day20;

public record Border(int border) {

    public static Border fromString(String input) {
        return new Border(Integer.parseInt(input.replace('#', '1').replace('.', '0'), 2));
    }

    public Border flipBorder() {
        return new Border(Integer.reverse(border) >> 22 & 0b1111111111);
    }

    @Override
    public String toString() {
        return String.format("%10s", Integer.toBinaryString(border)).replace('1', '#').replace('0', '.').replace(' ', '.') + "(" + border + ")";
    }
}
