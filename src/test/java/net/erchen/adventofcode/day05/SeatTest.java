package net.erchen.adventofcode.day05;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SeatTest {

    @Test
    void fromSeatNumber() {
        assertThat(Seat.fromSeatNumber("FBFBBFFRLR").getSeatId()).isEqualTo(357);
        assertThat(Seat.fromSeatNumber("BFFFBBFRRR").getSeatId()).isEqualTo(567);
        assertThat(Seat.fromSeatNumber("FFFBBBFRRR").getSeatId()).isEqualTo(119);
        assertThat(Seat.fromSeatNumber("BBFFBBFRLL").getSeatId()).isEqualTo(820);

    }
}