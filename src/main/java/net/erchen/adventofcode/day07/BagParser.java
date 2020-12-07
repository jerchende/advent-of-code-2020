package net.erchen.adventofcode.day07;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import static java.util.Collections.emptyMap;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toMap;

public class BagParser {

    private final static Pattern bagContentPattern = Pattern.compile("([0-9]+) (.+?) bags?[,.]");

    public static List<Bag> parseBags(List<String> input) {
        var allBags = input.stream()
                .map(bagLine -> bagLine.split(" bags contain "))
                .collect(toMap(bagParts -> bagParts[0], bagParts -> new TemporaryBagHolder(new Bag(bagParts[0]), bagParts[1])));

        return allBags.values().stream().map(bagHolder -> linkBagTree(bagHolder, allBags)).collect(toList());
    }

    private static Bag linkBagTree(TemporaryBagHolder bagHolder, Map<String, TemporaryBagHolder> allBags) {
        var bag = bagHolder.getBag();
        if ("no other bags.".equals(bagHolder.getContent())) {
            bag.setAllowedBags(emptyMap());
        } else {
            bag.setAllowedBags(bagContentPattern.matcher(bagHolder.getContent()).results().map(matchResult -> Map.entry(allBags.get(matchResult.group(2)).getBag(), Integer.parseInt(matchResult.group(1)))).collect(toMap(Map.Entry::getKey, Map.Entry::getValue)));
        }

        return bag;
    }

    @Data
    @RequiredArgsConstructor
    private static class TemporaryBagHolder {
        private final Bag bag;
        private final String content;
    }
}
