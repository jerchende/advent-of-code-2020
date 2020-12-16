package net.erchen.adventofcode.day16;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class TicketDataTest {

    static List<String> demoInput() throws IOException {
        return Files.readAllLines(Path.of("src/test/resources/day16/demo.txt"));
    }


    static List<String> solutionInput() throws IOException {
        return Files.readAllLines(Path.of("src/test/resources/day16/input.txt"));
    }

    @Test
    void fromInput() throws IOException {
        var ticketData = TicketData.fromInput(demoInput());

        assertThat(ticketData.getFields()).extracting("field").containsExactlyInAnyOrder("class", "row", "seat");
        assertThat(ticketData.getYourTicket()).isEqualTo(Ticket.fromInput("7,1,14"));
        assertThat(ticketData.getNearbyTickets()).containsExactlyInAnyOrder(Ticket.fromInput("7,3,47"), Ticket.fromInput("40,4,50"), Ticket.fromInput("55,2,20"), Ticket.fromInput("38,6,12"));
    }


    @Test
    void isMatchingNoField() throws IOException {
        var ticketData = TicketData.fromInput(demoInput());

        assertThat(ticketData.isMatchingNoField(4)).isTrue();
        assertThat(ticketData.isMatchingNoField(20)).isFalse();
    }

    @Test
    void sumAllInvalidTicketData_Demo() throws IOException {
        var ticketData = TicketData.fromInput(demoInput());

        assertThat(ticketData.sumAllInvalidTicketData()).isEqualTo(71);
    }

    @Test
    void sumAllInvalidTicketData_Solution() throws IOException {
        var ticketData = TicketData.fromInput(solutionInput());

        assertThat(ticketData.sumAllInvalidTicketData()).isEqualTo(32835);
    }

    @Test
    void validTicket() throws IOException {
        var ticketData = TicketData.fromInput(demoInput());

        assertThat(ticketData.validTickets()).containsExactly(Ticket.fromInput("7,3,47"));
    }

    @Test
    void ticketFieldsInOrder() throws IOException {
        var ticketData = TicketData.fromInput(demoInput());

        assertThat(ticketData.getTicketFieldsInOrder()).extracting("field").containsExactly("row", "class", "seat");
    }

    @Test
    void departureProduct_Solution() throws IOException {
        var ticketData = TicketData.fromInput(solutionInput());

        assertThat(ticketData.departureProduct()).isEqualTo(514662805187L);
    }
}