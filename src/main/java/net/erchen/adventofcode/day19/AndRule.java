package net.erchen.adventofcode.day19;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

@Data
@RequiredArgsConstructor
public class AndRule implements Rule {

    private final List<RuleId> rules;

    @EqualsAndHashCode.Exclude
    private final RuleProvider ruleProvider;

    @Override
    public List<String> consume(String input) throws InvalidException {
        if (rules.size() == 1) {
            return ruleProvider.getRule(rules.get(0)).consume(input);
        }

        var allowed = ruleProvider.getRule(rules.get(0)).consume(input).stream().flatMap(combi -> {
                    try {
                        return new AndRule(rules.subList(1, rules.size()), ruleProvider).consume(combi).stream();
                    } catch (InvalidException e) {
                        return Stream.empty();
                    }
                }
        ).collect(toList());
        if (allowed.isEmpty()) {
            throw new InvalidException();
        }
        return allowed;
    }
}
