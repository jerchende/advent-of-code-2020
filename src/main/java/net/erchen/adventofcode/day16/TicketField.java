package net.erchen.adventofcode.day16;

import lombok.AccessLevel;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.lang.Integer.parseInt;
import static java.util.stream.Collectors.toSet;

@Data
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class TicketField {

    private final String field;
    private final Set<Integer> validValues;

    public static TicketField fromInput(String input) {
        var splits = input.split(":");
        return new TicketField(splits[0], parseValidationRules(splits[1]));

    }

    private static Set<Integer> parseValidationRules(String validationRules) {
        return Stream.of(validationRules.trim().split(" or "))
                .flatMapToInt(rule -> {
                    var numbers = rule.split("-");
                    return IntStream.rangeClosed(parseInt(numbers[0]), parseInt(numbers[1]));
                })
                .boxed()
                .collect(toSet());
    }

    public IntStream validValues() {
        return validValues.stream().mapToInt(Integer::intValue);
    }

    public boolean allValid(List<Integer> values) {
        return validValues.containsAll(values);
    }

}
