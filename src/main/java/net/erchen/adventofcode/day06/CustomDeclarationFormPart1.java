package net.erchen.adventofcode.day06;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;

@Data
@RequiredArgsConstructor
public class CustomDeclarationFormPart1 {

    private final Set<Character> answers;

    public static List<CustomDeclarationFormPart1> parseCustomDeclarationForms(String answers) {
        return Stream.of(answers.split("\n\n"))
                .map(CustomDeclarationFormPart1::parseCustomDeclarationForm)
                .collect(toList());
    }

    static CustomDeclarationFormPart1 parseCustomDeclarationForm(String answers) {
        return new CustomDeclarationFormPart1(normalizeInput(answers).chars().mapToObj(c -> (char) c).collect(toSet()));
    }

    private static String normalizeInput(String input) {
        return input.replaceAll("\\s+", "");
    }

}
