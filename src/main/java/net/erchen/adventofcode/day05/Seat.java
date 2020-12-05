package net.erchen.adventofcode.day05;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Seat {

    private final int seatId;

    public static Seat fromSeatNumber(String seatNumber) {
        return new Seat(Integer.parseInt(toBinaryString(seatNumber), 2));
    }

    private static String toBinaryString(String seatNumber) {
        return seatNumber.replace('B', '1').replace('F', '0').replace('R', '1').replace('L', '0');
    }
}