package net.erchen.adventofcode.day22;

import static java.lang.Integer.parseInt;

public record Card(int cardValue) implements Comparable<Card> {

    public static Card fromString(String input) {
        return new Card(parseInt(input));
    }

    @Override
    public int compareTo(Card o) {
        if (o == null) {
            throw new IllegalArgumentException();
        }
        return Integer.compare(this.cardValue, o.cardValue);
    }

}
