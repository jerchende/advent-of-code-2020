package net.erchen.adventofcode.day08;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ProcessorTest {

    @Test
    void shouldDoNothing() throws LoopException {
        var processor = new Processor(List.of());

        processor.process();

        assertThat(processor.getAccumulator()).isEqualTo(0);
    }

    @Test
    void shouldAcc() throws LoopException {
        var processor = new Processor(List.of(new Command(Operation.acc, 5)));

        processor.process();

        assertThat(processor.getAccumulator()).isEqualTo(5);
    }

    @Test
    void shouldAccMultiple() throws LoopException {
        var processor = new Processor(List.of(new Command(Operation.acc, 5), new Command(Operation.acc, 7)));

        processor.process();

        assertThat(processor.getAccumulator()).isEqualTo(12);
    }

    @Test
    void shouldNopMultiple() throws LoopException {
        var processor = new Processor(List.of(new Command(Operation.nop, 5), new Command(Operation.nop, 5)));

        processor.process();

        assertThat(processor.getAccumulator()).isEqualTo(0);
    }

    @Test
    void shouldJmp() throws LoopException {
        var processor = new Processor(List.of(new Command(Operation.jmp, 2), new Command(Operation.acc, 5), new Command(Operation.acc, 2)));

        processor.process();

        assertThat(processor.getAccumulator()).isEqualTo(2);
    }


    @Test
    void shouldCombineMultiple() throws LoopException {
        var processor = new Processor(List.of(new Command(Operation.acc, 5), new Command(Operation.nop, 5)));

        processor.process();

        assertThat(processor.getAccumulator()).isEqualTo(5);
    }
}