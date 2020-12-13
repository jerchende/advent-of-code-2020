package net.erchen.adventofcode.day13;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BusRouteTest {

    @Test
    void nextDepartment() {
        assertThat(new BusRoute(7, 0).nextDepartment(939)).isEqualTo(6);
        assertThat(new BusRoute(59, 0).nextDepartment(939)).isEqualTo(5);
        assertThat(new BusRoute(59, 0).nextDepartment(939)).isEqualTo(5);
    }
}