package net.erchen.adventofcode.day09;

import com.google.common.collect.Sets;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.Set;

@SuppressWarnings("UnstableApiUsage")
@Data
@RequiredArgsConstructor
public class Number {

    public final Set<Long> previousNumbers;
    public final long currentNumber;

    public boolean isValid() {
        return Sets.combinations(previousNumbers, 2).stream()
                .anyMatch(pair -> pair.stream().mapToLong(Long::longValue).sum() == currentNumber);
    }
}
