package net.erchen.adventofcode.day02;

import java.util.List;
import java.util.regex.Pattern;

import static java.lang.Integer.parseInt;

public class Day02Part2 {

    private final static Pattern passwordRulePattern = Pattern.compile("([0-9]+)-([0-9]+) (.): (.*)");

    public static boolean isPasswordValid(String passwordRule) {
        var matcher = passwordRulePattern.matcher(passwordRule);
        if (!matcher.matches()) {
            throw new IllegalArgumentException("Can not parse :" + passwordRule);
        }
        var first = parseInt(matcher.group(1)) - 1;
        var second = parseInt(matcher.group(2)) - 1;
        var character = matcher.group(3).charAt(0);
        var password = matcher.group(4);


        return (password.charAt(first) == character) ^ (password.charAt(second) == character);
    }

    public static long countValidPassword(List<String> passwordRules) {
        return passwordRules.stream().filter(Day02Part2::isPasswordValid).count();
    }
}
