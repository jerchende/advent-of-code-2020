package net.erchen.adventofcode.day16;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class TicketTest {

    @Test
    void fromInput() {
        assertThat(Ticket.fromInput("7,1,14").getNumbers()).containsExactlyInAnyOrder(7, 1, 14);
        assertThat(Ticket.fromInput("1, 2, 3").getNumbers()).containsExactlyInAnyOrder(1, 2, 3);
    }

    @Test
    void fieldMatches() {
        var ticket = Ticket.fromInput("7,1,14");

        assertThat(ticket.fieldsMatches(List.of(TicketField.fromInput("f1: 1-2 or 6-7"), TicketField.fromInput("f1: 1-2 or 6-7"), TicketField.fromInput("f1: 1-2 or 13-14")))).isTrue();
        assertThat(ticket.fieldsMatches(List.of(TicketField.fromInput("f1: 1-2 or 6-7"), TicketField.fromInput("f1: 1-2 or 6-7"), TicketField.fromInput("f1: 1-2 or 12-13")))).isFalse();

    }
}