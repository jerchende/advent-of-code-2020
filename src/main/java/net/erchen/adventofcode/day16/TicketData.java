package net.erchen.adventofcode.day16;

import lombok.AccessLevel;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toMap;

@Data
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class TicketData {

    private final List<TicketField> fields;
    private final Ticket yourTicket;
    private final List<Ticket> nearbyTickets;

    public static TicketData fromInput(List<String> input) {
        List<TicketField> fields = new LinkedList<>();
        Ticket yourTicket = null;
        List<Ticket> nearbyTickets = new LinkedList<>();

        var section = "fields:";

        for (String inputLine : input) {
            if (inputLine.trim().isBlank()) {
                continue;
            }
            if (inputLine.endsWith(":")) {
                section = inputLine;
                continue;
            }

            switch (section) {
                case "fields:" -> fields.add(TicketField.fromInput(inputLine));
                case "your ticket:" -> yourTicket = Ticket.fromInput(inputLine);
                case "nearby tickets:" -> nearbyTickets.add(Ticket.fromInput(inputLine));

            }
        }

        return new TicketData(fields, yourTicket, nearbyTickets);
    }

    public Stream<Ticket> validTickets() {
        return nearbyTickets.stream().filter(ticket -> ticket.getNumbers().stream().noneMatch(this::isMatchingNoField));
    }

    public long sumAllInvalidTicketData() {
        return nearbyTickets.stream().flatMapToInt(Ticket::numbers).filter(this::isMatchingNoField).sum();
    }

    public boolean isMatchingNoField(int number) {
        return this.fields.stream().flatMapToInt(TicketField::validValues).noneMatch(i -> i == number);
    }

    public List<TicketField> getTicketFieldsInOrder() {
        var validFieldsPerPosition = findValidFieldPerPosition();

        var uniquePosition = new HashSet<>();
        while (uniquePosition.size() < fields.size()) {
            var uniqueField = findFirstUnprocessedUniqueField(validFieldsPerPosition, uniquePosition);
            removeFieldFromOtherPositions(validFieldsPerPosition, uniqueField);
            uniquePosition.add(uniqueField.getKey());
        }

        return validFieldsPerPosition.values().stream().map(l -> l.get(0)).collect(toList());
    }

    private void removeFieldFromOtherPositions(Map<Integer, List<TicketField>> validFieldsPerPosition, Map.Entry<Integer, List<TicketField>> uniqueField) {
        validFieldsPerPosition.entrySet().stream().filter(entry -> !entry.getKey().equals(uniqueField.getKey())).map(Map.Entry::getValue).forEach(list -> list.remove(uniqueField.getValue().get(0)));
    }

    private Map.Entry<Integer, List<TicketField>> findFirstUnprocessedUniqueField(Map<Integer, List<TicketField>> validFieldsPerPosition, HashSet<Object> uniquePosition) {
        return validFieldsPerPosition.entrySet().stream().filter(entry -> !uniquePosition.contains(entry.getKey())).filter(entry -> entry.getValue().size() == 1).findFirst().orElseThrow();
    }

    private Map<Integer, List<TicketField>> findValidFieldPerPosition() {
        return IntStream.range(0, fields.size()).boxed().collect(toMap(p -> p, this::validFieldsOnPosition));
    }

    private List<TicketField> validFieldsOnPosition(int position) {
        var numbers = validTickets().map(ticket -> ticket.getNumbers().get(position)).collect(toList());
        return fields.stream().filter(field -> field.allValid(numbers)).collect(toList());
    }

    public long departureProduct() {
        long departureProduct = 1;
        var orderedFields = getTicketFieldsInOrder();
        for (int i = 0; i < orderedFields.size(); i++) {
            if (orderedFields.get(i).getField().startsWith("departure")) {
                departureProduct *= yourTicket.getNumbers().get(i);
            }
        }
        return departureProduct;
    }


}
