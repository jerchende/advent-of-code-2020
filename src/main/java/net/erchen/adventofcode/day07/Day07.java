package net.erchen.adventofcode.day07;

import java.util.List;

public class Day07 {

    public static long countBagContaining(List<String> input, String search) {
        var bags = BagParser.parseBags(input);
        var containingBag = findBagByColor(bags, search);

        return bags.stream().filter(bag -> bag.canContain(containingBag)).count();
    }

    public static long countBagNeeded(List<String> input, String search) {
        var bags = BagParser.parseBags(input);
        return findBagByColor(bags, search).totalBagCount();
    }

    private static Bag findBagByColor(List<Bag> bags, String search) {
        return bags.stream().filter(b -> b.getColor().equals(search)).findFirst().orElseThrow();
    }
}
