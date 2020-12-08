package net.erchen.adventofcode.day08;

import java.util.LinkedList;
import java.util.List;

public class Day08 {

    public static int getValueBeforeInfiniteLoop(List<String> input) {
        var processor = new Processor(Command.parseFromInput(input));
        try {
            processor.process();
            throw new IllegalArgumentException("No infinite loop detected");
        } catch (LoopException e) {
            return processor.getAccumulator();
        }
    }

    public static int runCorrectedProgram(List<String> input) {
        var commands = Command.parseFromInput(input);

        for (int i = 0; i < commands.size(); i++) {
            if (commands.get(i).getOperation() == Operation.acc) {
                continue;
            }

            var fixedCommands = new LinkedList<>(commands);
            fixedCommands.set(i, toogleOperation(commands.get(i)));

            try {
                var processor = new Processor(fixedCommands);
                processor.process();
                return processor.getAccumulator();
            } catch (LoopException e) {
                continue;
            }
        }
        throw new IllegalArgumentException("Could not fix programm");
    }

    private static Command toogleOperation(Command command) {
        return switch (command.getOperation()) {
            case jmp -> new Command(Operation.nop, command.getArgument());
            case nop -> new Command(Operation.jmp, command.getArgument());
            default -> throw new IllegalArgumentException("can not toggle " + command);
        };
    }
}
