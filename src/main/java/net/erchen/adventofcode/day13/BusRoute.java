package net.erchen.adventofcode.day13;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class BusRoute {

    private final long route;
    private final int offset;

    public long nextDepartment(int currentTimestamp) {
        return route - (currentTimestamp % route);
    }
}
