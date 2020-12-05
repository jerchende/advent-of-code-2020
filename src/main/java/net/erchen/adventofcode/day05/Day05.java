package net.erchen.adventofcode.day05;

import java.util.List;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;

public class Day05 {

    public static int findHighestSeatId(List<String> seatNumbers) {
        return seatNumbers.stream().map(Seat::fromSeatNumber).max(comparing(Seat::getSeatId)).orElseThrow().getSeatId();
    }


    public static int findYourSeatId(List<String> seatNumbers) {
        var seatStatistics = seatNumbers.stream().map(Seat::fromSeatNumber).mapToInt(Seat::getSeatId).summaryStatistics();
        var allSeats = seatNumbers.stream().map(Seat::fromSeatNumber).map(Seat::getSeatId).collect(toList());

        for (int i = seatStatistics.getMin() + 1; i < seatStatistics.getMax(); i++) {
            if (!allSeats.contains(i) && allSeats.contains(i - 1) && allSeats.contains(i + 1)) {
                return i;
            }
        }
        return 0;
    }
}
