package net.erchen.adventofcode.day14;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.LongStream;


@Getter
@RequiredArgsConstructor
public class DockingProcessor {

    private final Map<Long, Long> values = new HashMap<>();
    private BitMask bitMask = BitMask.fromString("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
    private final boolean maskAddresses;

    public void applyCommand(Command command) {
        if (command instanceof SetMaskCommand setMaskCommand) {
            this.bitMask = setMaskCommand.getBitMask();
        } else if (command instanceof WriteCommand writeCommand) {
            if (maskAddresses) {
                LongStream.of(bitMask.applyMaskOnAddress(writeCommand.getAddress())).forEach(address -> this.values.put(address, writeCommand.getValue()));
            } else {
                this.values.put(writeCommand.getAddress(), bitMask.applyMaskOnValue(writeCommand.getValue()));
            }
        } else {
            throw new IllegalArgumentException("Unsupported Command: " + command);
        }
    }

    public long getSumOfAllValues() {
        return values.values().stream().mapToLong(Long::longValue).sum();
    }

    public static DockingProcessor fromCommands(List<String> command, boolean maskAddresses) {
        var dockingProcessor = new DockingProcessor(maskAddresses);
        command.stream().map(DockingProcessor::mapToCommand).forEachOrdered(dockingProcessor::applyCommand);
        return dockingProcessor;
    }

    private static Command mapToCommand(String s) {
        if (SetMaskCommand.isSetMaskCommand(s)) {
            return SetMaskCommand.fromString(s);
        } else if (WriteCommand.isWriteCommand(s)) {
            return WriteCommand.fromString(s);
        } else {
            throw new IllegalArgumentException("unknown command " + s);
        }
    }

}
