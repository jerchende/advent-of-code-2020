package net.erchen.adventofcode.day16;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class TicketFieldTest {

    @Test
    void fromInput() {
        var ticketField = TicketField.fromInput("class: 1-3 or 5-7");
        assertThat(ticketField.getField()).isEqualTo("class");
        assertThat(ticketField.getValidValues()).containsExactly(1, 2, 3, 5, 6, 7);

        ticketField = TicketField.fromInput("departure location: 30-260 or 284-950");
        assertThat(ticketField.getField()).isEqualTo("departure location");
        assertThat(ticketField.getValidValues()).contains(30, 31, 32, 259, 260, 284, 949, 950).hasSize(898);

        ticketField = TicketField.fromInput("class: 47-536 or 557-964");
        assertThat(ticketField.getField()).isEqualTo("class");
        assertThat(ticketField.getValidValues()).contains(47, 48, 49, 533, 534, 535, 536, 557, 558, 559, 560, 963, 964).hasSize(898);
    }

    @Test
    void allValid() {
        var ticketField = TicketField.fromInput("class: 47-536 or 557-964");

        assertThat(ticketField.allValid(List.of(47))).isTrue();
        assertThat(ticketField.allValid(List.of(47, 55, 65, 77, 558))).isTrue();
        assertThat(ticketField.allValid(List.of(47, 55, 65, 77, 999))).isFalse();
        assertThat(ticketField.allValid(List.of(999))).isFalse();
    }
}