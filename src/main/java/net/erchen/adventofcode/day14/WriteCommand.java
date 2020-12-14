package net.erchen.adventofcode.day14;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.regex.Pattern;

import static java.lang.Long.parseLong;
import static java.lang.Long.parseUnsignedLong;

@Getter
@RequiredArgsConstructor
public class WriteCommand implements Command {

    private final static Pattern commandPattern = Pattern.compile("mem\\[([0-9]+)\\] = ([0-9]+)");

    private final long address;
    private final long value;


    public static WriteCommand fromString(String input) {
        var matcher = commandPattern.matcher(input);
        if (!matcher.matches()) {
            throw new IllegalArgumentException("unknown input: " + input);
        }
        return new WriteCommand(parseLong(matcher.group(1)), parseUnsignedLong(matcher.group(2)));
    }


    public static boolean isWriteCommand(String input) {
        return commandPattern.matcher(input).matches();
    }


}
