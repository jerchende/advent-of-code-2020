package net.erchen.adventofcode.day19;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class OrRule implements Rule {

    private final Rule leftRule;
    private final Rule rightRule;

    @Override
    public String consume(String input) throws NotValidException {
        try {
            return leftRule.consume(input);
        } catch (NotValidException e) {
            return rightRule.consume(input);
        }
    }
}
