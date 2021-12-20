package net.erchen.adventofcode.day23;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CrabCupTest {

    @Test
    void shouldParse() {
        var crabCup = CrabCup.fromInput("32415");

        assertThat(crabCup.getCurrentCup().value()).isEqualTo(3);
        assertThat(crabCup.getCurrentCup().next().value()).isEqualTo(2);
        assertThat(crabCup.getCurrentCup().next(2).value()).isEqualTo(4);
        assertThat(crabCup.getCurrentCup().next(3).value()).isEqualTo(1);
        assertThat(crabCup.getCurrentCup().next(4).value()).isEqualTo(5);
        assertThat(crabCup.getCurrentCup().next(5).value()).isEqualTo(3);
    }

    @Test
    void shouldFindDestination() {
        var crabCup = CrabCup.fromInput("389125467");

        assertThat(crabCup.destination(List.of(8, 9, 1)).value()).isEqualTo(2);
        assertThat(crabCup.destination(List.of(2, 1)).value()).isEqualTo(9);
        assertThat(crabCup.destination(List.of()).value()).isEqualTo(2);
        assertThat(crabCup.destination(List.of(2, 1, 9, 8, 7, 6, 5)).value()).isEqualTo(4);
        assertThat(crabCup.destination(List.of(2, 1, 9, 8)).value()).isEqualTo(7);
    }

    @Test
    void shouldDoMove() {
        var crabCup = CrabCup.fromInput("389125467");

        assertThat(crabCup.toString()).isEqualTo("389125467");

        crabCup.move();
        assertThat(crabCup.toString()).isEqualTo("289154673");

        crabCup.move();
        assertThat(crabCup.toString()).isEqualTo("546789132");

        crabCup.move();
        assertThat(crabCup.toString()).isEqualTo("891346725");

        crabCup.move();
        assertThat(crabCup.toString()).isEqualTo("467913258");

        crabCup.move();
        assertThat(crabCup.toString()).isEqualTo("136792584");

        crabCup.move();
        assertThat(crabCup.toString()).isEqualTo("936725841");

        crabCup.move();
        assertThat(crabCup.toString()).isEqualTo("258367419");

        crabCup.move();
        assertThat(crabCup.toString()).isEqualTo("674158392");

        crabCup.move();
        assertThat(crabCup.toString()).isEqualTo("574183926");

        crabCup.move();
        assertThat(crabCup.toString()).isEqualTo("837419265");
    }

    @Test
    void shouldDo10Moves() {
        var crabCup = CrabCup.fromInput("389125467");
        crabCup.move(10);
        assertThat(crabCup.toString()).isEqualTo("837419265");
        assertThat(crabCup.numberAfterOne()).isEqualTo("92658374");
    }

    @Test
    void shouldDo100Moves_Sample() {
        var crabCup = CrabCup.fromInput("389125467");
        crabCup.move(100);
        assertThat(crabCup.numberAfterOne()).isEqualTo("67384529");
    }

    @Test
    void shouldDo100Moves_Solution() {
        var crabCup = CrabCup.fromInput("963275481");
        crabCup.move(100);
        assertThat(crabCup.numberAfterOne()).isEqualTo("97632548");
    }

    @Test
    void shouldDo10000000Moves_Sample() {
        var crabCup = CrabCup.fromInput("389125467", true);
        crabCup.move(10000000);
        assertThat(crabCup.nextTwo()).isEqualTo(149245887792L);
    }

    @Test
    void shouldDo10000000Moves_Solution() {
        var crabCup = CrabCup.fromInput("963275481", true);
        crabCup.move(10000000);
        assertThat(crabCup.nextTwo()).isEqualTo(412990492266L);
    }

}