package net.erchen.adventofcode.day18;

import java.util.List;

public class Expressions {

    public static long sumAllExpressions(List<String> input, Expression.RuleSet ruleSet) {
        return input.stream().map(line -> new Expression(line, ruleSet)).mapToLong(Expression::evaluate).sum();
    }
}
