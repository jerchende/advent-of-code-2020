package net.erchen.adventofcode.day17;

import java.util.*;

import static java.util.Collections.emptyMap;
import static java.util.Collections.emptySet;

public class ConwayCubes4D {
    // stores the active cubes (w, z, y, x)
    private Map<Integer, Map<Integer, Map<Integer, Set<Integer>>>> cubes = new HashMap<>();
    private int initDimension = 0;
    private int bootSequence = 0;

    public void init(List<String> input) {
        initDimension = input.size();

        int z = 0;
        int w = 0;
        for (int y = 0; y < initDimension; y++) {
            var line = input.get(y).toCharArray();
            for (int x = 0; x < initDimension; x++) {
                this.setCube(x, y, z, w, line[x] == '#');
            }
        }
    }

    private static void setCube(Map<Integer, Map<Integer, Map<Integer, Set<Integer>>>> cubes, int x, int y, int z, int w, boolean active) {

        if (!cubes.containsKey(w)) {
            cubes.put(w, new HashMap<>());
        }
        if (!cubes.get(w).containsKey(z)) {
            cubes.get(w).put(z, new HashMap<>());
        }
        if (!cubes.get(w).get(z).containsKey(y)) {
            cubes.get(w).get(z).put(y, new HashSet<>());
        }
        if (active) {
            cubes.get(w).get(z).get(y).add(x);
        } else {
            cubes.get(w).get(z).get(y).remove(x);
        }
    }

    public void setCube(int x, int y, int z, int w, boolean active) {
        setCube(cubes, x, y, z, w, active);
    }

    public boolean getCube(int x, int y, int z, int w) {
        return cubes.getOrDefault(w, emptyMap()).getOrDefault(z, emptyMap()).getOrDefault(y, emptySet()).contains(x);
    }

    public List<Boolean> adjacentCubes(int cubeX, int cubeY, int cubeZ, int cubeW) {
        List<Boolean> adjacentCubes = new LinkedList<>();
        for (int w = cubeW - 1; w <= cubeW + 1; w++) {
            for (int z = cubeZ - 1; z <= cubeZ + 1; z++) {
                for (int y = cubeY - 1; y <= cubeY + 1; y++) {
                    for (int x = cubeX - 1; x <= cubeX + 1; x++) {
                        if (x != cubeX || y != cubeY || z != cubeZ || w != cubeW) {
                            adjacentCubes.add(getCube(x, y, z, w));
                        }
                    }
                }
            }
        }
        return adjacentCubes;
    }

    public int countActiveAdjacentCubes(int cubeX, int cubeY, int cubeZ, int cubeW) {
        return (int) adjacentCubes(cubeX, cubeY, cubeZ, cubeW).stream().filter(b -> b).count();
    }

    public long countActiveCubes() {
        return cubes.values().stream().flatMap(m -> m.values().stream()).flatMap(m -> m.values().stream()).flatMap(Collection::stream).count();
    }

    public void boot() {
        for (int round = 0; round < 6; round++) {
            Map<Integer, Map<Integer, Map<Integer, Set<Integer>>>> newCubeStates = new HashMap<>();

            for (int w = -1 - bootSequence; w <= 2 + bootSequence; w++) {
                for (int z = -1 - bootSequence; z <= 2 + bootSequence; z++) {
                    for (int y = -1 - bootSequence; y <= initDimension + bootSequence + 1; y++) {
                        for (int x = -1 - bootSequence; x <= initDimension + bootSequence + 1; x++) {
                            var isActive = getCube(x, y, z, w);
                            var activeAdjacentCount = countActiveAdjacentCubes(x, y, z, w);
                            if (isActive) {
                                setCube(newCubeStates, x, y, z, w, activeAdjacentCount == 2 || activeAdjacentCount == 3);
                            } else {
                                setCube(newCubeStates, x, y, z, w, activeAdjacentCount == 3);
                            }
                        }
                    }
                }
            }

            this.cubes = newCubeStates;
            this.bootSequence++;
        }
    }


}
