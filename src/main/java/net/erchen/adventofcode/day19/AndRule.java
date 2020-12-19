package net.erchen.adventofcode.day19;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
@RequiredArgsConstructor
public class AndRule implements Rule {

    private final List<RuleId> rules;

    @EqualsAndHashCode.Exclude
    private final RuleProvider ruleProvider;

    @Override
    public String consume(String input) throws NotValidException {
        String remainingInput = input;
        for (RuleId ruleId : rules) {
            var rule = ruleProvider.getRule(ruleId);
            remainingInput = rule.consume(remainingInput);
        }
        return remainingInput;
    }
}
