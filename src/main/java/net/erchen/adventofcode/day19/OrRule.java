package net.erchen.adventofcode.day19;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.LinkedList;
import java.util.List;

@Data
@RequiredArgsConstructor
public class OrRule implements Rule {

    private final Rule leftRule;
    private final Rule rightRule;

    @Override
    public List<String> consume(String input) throws InvalidException {
        List<String> matchingReturns = new LinkedList<>();
        try {
            matchingReturns.addAll(leftRule.consume(input));
        } catch (InvalidException e) {
        }

        try {
            matchingReturns.addAll(rightRule.consume(input));
        } catch (InvalidException e) {
        }

        if (matchingReturns.isEmpty()) {
            throw new InvalidException();
        }
        return matchingReturns;
    }
}
