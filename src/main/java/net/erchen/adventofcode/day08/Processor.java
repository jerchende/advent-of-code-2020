package net.erchen.adventofcode.day08;

import lombok.RequiredArgsConstructor;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;


@RequiredArgsConstructor
public class Processor {

    private final AtomicInteger accumulator = new AtomicInteger(0);
    private final Set<Integer> runnedCommandLines = new HashSet<>();
    private final List<Command> commands;

    public void process() throws LoopException {
        for (int currentLine = 0; currentLine < commands.size(); ) {
            if (runnedCommandLines.contains(currentLine)) {
                throw new LoopException("Already Executed line #" + currentLine);
            }
            runnedCommandLines.add(currentLine);

            var currentCommand = commands.get(currentLine);
            switch (currentCommand.getOperation()) {
                case jmp:
                    currentLine += currentCommand.getArgument();
                    break;
                case acc:
                    accumulator.addAndGet(currentCommand.getArgument());
                case nop:
                    currentLine++;
            }
        }
    }

    public int getAccumulator() {
        return this.accumulator.get();
    }
}
