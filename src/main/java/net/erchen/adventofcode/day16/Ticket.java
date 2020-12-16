package net.erchen.adventofcode.day16;

import lombok.AccessLevel;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

@Data
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class Ticket {

    private final List<Integer> numbers;

    public static Ticket fromInput(String input) {
        return new Ticket(Stream.of(input.split(",")).map(String::trim).map(Integer::parseInt).collect(Collectors.toList()));
    }

    public IntStream numbers() {
        return numbers.stream().mapToInt(Integer::intValue);
    }

    public boolean fieldsMatches(List<TicketField> fields) {
        if (fields.size() != numbers.size()) {
            return false;
        }

        for (int i = 0; i < fields.size(); i++) {
            if (!fields.get(i).getValidValues().contains(numbers.get(i))) {
                return false;
            }
        }
        return true;
    }

}
