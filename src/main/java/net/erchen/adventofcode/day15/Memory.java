package net.erchen.adventofcode.day15;

import java.util.HashMap;
import java.util.Map;

public class Memory {

    public static int playMemory(int[] init, int rounds) {
        var cache = initCache(init);

        int lastNumber = init[init.length - 1];
        for (int round = init.length; round <= rounds; round++) {
            int newNumber = lastNumberSpoken(cache, lastNumber, round);
            cache.put(lastNumber, round - 1);
            lastNumber = newNumber;
        }
        return lastNumber;
    }

    private static Map<Integer, Integer> initCache(int[] init) {
        var cache = new HashMap<Integer, Integer>();
        for (int i = 0; i < init.length - 1; i++) {
            cache.put(init[i], i);
        }
        return cache;
    }

    private static int lastNumberSpoken(Map<Integer, Integer> cache, int number, int currentRound) {
        var lastNumber = cache.get(number);
        return lastNumber == null ? 0 : currentRound - lastNumber - 1;
    }
}
