package net.erchen.adventofcode.day05;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SeatTest {

    @Test
    void calculateRow() {
        assertThat(new Seat(357).getRow()).isEqualTo(44);
        assertThat(new Seat(567).getRow()).isEqualTo(70);
        assertThat(new Seat(119).getRow()).isEqualTo(14);
        assertThat(new Seat(820).getRow()).isEqualTo(102);
    }

    @Test
    void calculateColumn() {
        assertThat(new Seat(357).getColumn()).isEqualTo(5);
        assertThat(new Seat(567).getColumn()).isEqualTo(7);
        assertThat(new Seat(119).getColumn()).isEqualTo(7);
        assertThat(new Seat(820).getColumn()).isEqualTo(4);
    }

    @Test
    void fromSeatNumber() {
        assertThat(Seat.fromSeatNumber("FBFBBFFRLR").getSeatId()).isEqualTo(357);
        assertThat(Seat.fromSeatNumber("BFFFBBFRRR").getSeatId()).isEqualTo(567);
        assertThat(Seat.fromSeatNumber("FFFBBBFRRR").getSeatId()).isEqualTo(119);
        assertThat(Seat.fromSeatNumber("BBFFBBFRLL").getSeatId()).isEqualTo(820);

    }
}