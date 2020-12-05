package net.erchen.adventofcode.day04;

import javax.validation.Validation;
import javax.validation.Validator;

public class Day04 {

    private final static Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

    public static long countValidPassesPart1(String input) {
        return Passport.parsePassports(input).stream().filter(passport -> validator.validate(passport, Part1ValidationGroup.class).isEmpty()).count();
    }

    public static long countValidPassesPart2(String input) {
        return Passport.parsePassports(input).stream().filter(passport -> validator.validate(passport, Part2ValidationGroup.class).isEmpty()).count();
    }

}
