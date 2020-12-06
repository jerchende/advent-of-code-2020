package net.erchen.adventofcode.day06;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;

@Data
@RequiredArgsConstructor
public class CustomDeclarationFormPart2 {

    private final List<CustomDeclarationFormPart1> answers;

    public static List<CustomDeclarationFormPart2> parseCustomDeclarationForms(String answers) {
        return Stream.of(answers.split("\n\n"))
                .map(CustomDeclarationFormPart2::parseCustomDeclarationForm)
                .collect(toList());
    }

    static CustomDeclarationFormPart2 parseCustomDeclarationForm(String answers) {
        return new CustomDeclarationFormPart2(Stream.of(answers.split("\n"))
                .map(CustomDeclarationFormPart1::parseCustomDeclarationForm)
                .collect(toList()));
    }

    public Set<Character> getAnswersInCommon() {
        return answers.stream()
                .map(CustomDeclarationFormPart1::getAnswers)
                .flatMap(Collection::stream)
                .distinct()
                .filter(this::isCommonAnswer)
                .collect(toSet());
    }

    private boolean isCommonAnswer(Character c) {
        return answers.stream().allMatch(form -> form.getAnswers().contains(c));
    }

}
