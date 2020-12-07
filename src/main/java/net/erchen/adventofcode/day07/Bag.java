package net.erchen.adventofcode.day07;

import lombok.*;

import java.util.Map;


@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class Bag {

    private final String color;

    @EqualsAndHashCode.Exclude
    @Setter(AccessLevel.PACKAGE)
    private Map<Bag, Integer> allowedBags;

    public boolean canContain(Bag bag) {
        return allowedBags.containsKey(bag) || allowedBags.keySet().stream().anyMatch(containingBag -> containingBag.canContain(bag));
    }

    public long totalBagCount() {
        return allowedBags.entrySet().stream().mapToLong(entry -> entry.getValue() * (entry.getKey().totalBagCount() + 1)).sum();
    }
}
