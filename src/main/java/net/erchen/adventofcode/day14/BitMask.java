package net.erchen.adventofcode.day14;

import lombok.AccessLevel;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.HashSet;
import java.util.Set;

import static java.lang.Long.parseUnsignedLong;
import static java.util.stream.Collectors.toList;

@Data
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class BitMask {

    private final String bitMask;

    public static BitMask fromString(String bitMask) {
        return new BitMask(bitMask);
    }

    private long orMask() {
        return parseUnsignedLong(bitMask.replace("X", "0"), 2);
    }

    private long andMask() {
        return parseUnsignedLong(bitMask.replace("X", "1"), 2);
    }

    private long floatingMask() {
        return parseUnsignedLong(bitMask.replace("1", "0").replace("X", "1"), 2);
    }

    public long applyMaskOnValue(long value) {
        return (value | orMask()) & andMask();
    }

    private Set<Long> addressMasks() {
        Set<Long> masks = new HashSet<>();
        masks.add(0L);
        for (int i = 0; i < bitMask.length(); i++) {
            if (bitMask.charAt(i) == 'X') {
                long mask = 1L << (bitMask.length() - 1 - i);
                masks.addAll(masks.stream().map(m -> m | mask).collect(toList()));
            }
        }
        return masks;
    }

    public long[] applyMaskOnAddress(long address) {
        long lowerAddress = (address | orMask()) & ~floatingMask();
        return addressMasks().stream().mapToLong(Long::longValue).map(mask -> mask | lowerAddress).toArray();
    }
}
