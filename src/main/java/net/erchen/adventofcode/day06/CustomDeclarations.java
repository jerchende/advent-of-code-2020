package net.erchen.adventofcode.day06;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import net.erchen.adventofcode.common.parser.SeparatorParser;

import java.util.List;
import java.util.Set;
import java.util.function.Function;

@Data
@RequiredArgsConstructor
public class CustomDeclarations {

    private final List<CustomDeclarationGroup> groups;

    public static CustomDeclarations parseCustomDeclarationForms(String input) {
        return new CustomDeclarations(SeparatorParser.parseInput(input, "\n\n", CustomDeclarationGroup::parseCustomDeclarationForm));
    }

    public long countAllAnswers() {
        return countAnswers(CustomDeclarationGroup::getAllAnswers);
    }

    public int countCommonAnswers() {
        return countAnswers(CustomDeclarationGroup::getAnswersInCommon);
    }

    private int countAnswers(Function<CustomDeclarationGroup, Set<Character>> answerExtractor) {
        return groups.stream()
                .map(answerExtractor)
                .mapToInt(Set::size)
                .sum();
    }
}
