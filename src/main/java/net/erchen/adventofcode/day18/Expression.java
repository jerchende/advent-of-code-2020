package net.erchen.adventofcode.day18;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.function.Function;

public class Expression {

    private final String expression;
    private final RuleSet ruleSet;

    @Getter
    @RequiredArgsConstructor
    public enum RuleSet {
        Part1(Expression::calculatePart1), Part2(Expression::calculatePart2);

        private final Function<List<Operation>, Long> calulator;
    }

    public Expression(String expression, RuleSet ruleSet) {
        this.expression = expression.replace(" ", "");
        this.ruleSet = ruleSet;
    }

    private static long calculatePart1(List<Operation> operations) {
        return operations.stream().reduce(0L, (sum, operation) -> operation.evaluate(sum), Long::sum);
    }

    private static long calculatePart2(List<Operation> operations) {
        return calculatePart1(sumAdditions(operations));
    }

    private static List<Operation> sumAdditions(List<Operation> operations) {
        List<Operation> ret = new LinkedList<>();
        Stack<Operation> lastOperations = new Stack<>();

        for (Operation operation : operations) {
            switch (operation.getOperator()) {
                case '*', ' ' -> {
                    ret.add(operation);
                    lastOperations.push(operation);
                }
                case '+' -> lastOperations.peek().setValue(lastOperations.peek().getValue() + operation.getValue());
            }
        }
        return ret;
    }

    public long evaluate() {
        Stack<List<Operation>> stackedOperations = new Stack<>();
        List<Operation> operations = new LinkedList<>();
        char currentInstruction = ' ';

        for (char c : expression.toCharArray()) {
            switch (c) {
                case '*', '+' -> currentInstruction = c;
                case '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' -> operations.add(new Operation(currentInstruction, charToLong(c)));
                case '(' -> {
                    operations.add(new Operation(currentInstruction, 0));
                    stackedOperations.push(operations);
                    operations = new ArrayList<>();
                    currentInstruction = ' ';
                }
                case ')' -> {
                    long sum = ruleSet.getCalulator().apply(operations);
                    operations = stackedOperations.pop();
                    operations.get(operations.size() - 1).setValue(sum);
                }
            }
        }
        return ruleSet.getCalulator().apply(operations);
    }

    private static long charToLong(char c) {
        return c - '0';
    }

}
