package net.erchen.adventofcode.day19;

import java.util.List;

public interface Rule {

    List<String> consume(String input) throws InvalidException;

    default boolean isValid(String input) {
        try {
            return consume(input).stream().anyMatch(String::isEmpty);
        } catch (InvalidException e) {
            return false;
        }
    }

}
