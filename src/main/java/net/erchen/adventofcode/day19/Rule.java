package net.erchen.adventofcode.day19;

public interface Rule {

    String consume(String input) throws NotValidException;

    default boolean isValid(String input) {
        try {
            return consume(input).isEmpty();
        } catch (NotValidException e) {
            return false;
        }
    }

}
