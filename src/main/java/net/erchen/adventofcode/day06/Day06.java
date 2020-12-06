package net.erchen.adventofcode.day06;

import java.util.Set;

public class Day06 {

    public static long countUniqueAnswers(String input) {
        return CustomDeclarationFormPart1.parseCustomDeclarationForms(input).stream()
                .map(CustomDeclarationFormPart1::getAnswers)
                .mapToInt(Set::size)
                .sum();
    }

    public static long countCommonAnswers(String input) {
        return CustomDeclarationFormPart2.parseCustomDeclarationForms(input).stream()
                .map(CustomDeclarationFormPart2::getAnswersInCommon)
                .mapToInt(Set::size)
                .sum();
    }
}
