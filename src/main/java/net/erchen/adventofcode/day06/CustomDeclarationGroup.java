package net.erchen.adventofcode.day06;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import net.erchen.adventofcode.common.parser.SeparatorParser;

import java.util.Collection;
import java.util.List;
import java.util.Set;

import static java.util.stream.Collectors.toSet;

@Data
@RequiredArgsConstructor
public class CustomDeclarationGroup {

    private final List<CustomDeclarationForm> forms;

    static CustomDeclarationGroup parseCustomDeclarationForm(String answers) {
        return new CustomDeclarationGroup(SeparatorParser.parseInput(answers, "\n", CustomDeclarationForm::parseCustomDeclarationForm));
    }

    public Set<Character> getAllAnswers() {
        return forms.stream()
                .map(CustomDeclarationForm::getAnswers)
                .flatMap(Collection::stream)
                .collect(toSet());
    }

    public Set<Character> getAnswersInCommon() {
        return getAllAnswers().stream()
                .filter(this::isCommonAnswer)
                .collect(toSet());
    }

    private boolean isCommonAnswer(Character c) {
        return forms.stream().allMatch(form -> form.getAnswers().contains(c));
    }

}
