package net.erchen.adventofcode.day14;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class SetMaskCommand implements Command {

    private final BitMask bitMask;

    public static SetMaskCommand fromString(String input) {
        return new SetMaskCommand(BitMask.fromString(input.substring(7)));
    }

    public static boolean isSetMaskCommand(String input) {
        return input.startsWith("mask = ");
    }
}
