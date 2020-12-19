package net.erchen.adventofcode.day18;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Operation {
    private char operator;
    private long value;

    public long evaluate(long value2) {
        return switch (operator) {
            case '+' -> value + value2;
            case '*' -> value * value2;
            case ' ' -> value;
            default -> throw new IllegalArgumentException("unknown operator " + operator);
        };
    }
}