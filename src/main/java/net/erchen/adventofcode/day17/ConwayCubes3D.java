package net.erchen.adventofcode.day17;

import java.util.*;

import static java.util.Collections.emptyMap;
import static java.util.Collections.emptySet;

public class ConwayCubes3D {
    // stores the active cubes (z, y, x)
    private Map<Integer, Map<Integer, Set<Integer>>> cubes = new HashMap<>();
    private int initDimension = 0;
    private int bootSequence = 0;

    public void init(List<String> input) {
        initDimension = input.size();

        int z = 0;
        for (int y = 0; y < initDimension; y++) {
            var line = input.get(y).toCharArray();
            for (int x = 0; x < initDimension; x++) {
                this.setCube(x, y, z, line[x] == '#');
            }
        }
    }

    private static void setCube(Map<Integer, Map<Integer, Set<Integer>>> cubes, int x, int y, int z, boolean active) {
        if (!cubes.containsKey(z)) {
            cubes.put(z, new HashMap<>());
        }
        if (!cubes.get(z).containsKey(y)) {
            cubes.get(z).put(y, new HashSet<>());
        }
        if (active) {
            cubes.get(z).get(y).add(x);
        } else {
            cubes.get(z).get(y).remove(x);
        }
    }

    public void setCube(int x, int y, int z, boolean active) {
        setCube(cubes, x, y, z, active);
    }

    public boolean getCube(int x, int y, int z) {
        return cubes.getOrDefault(z, emptyMap()).getOrDefault(y, emptySet()).contains(x);
    }

    public List<Boolean> adjacentCubes(int cubeX, int cubeY, int cubeZ) {
        List<Boolean> adjacentCubes = new LinkedList<>();
        for (int z = cubeZ - 1; z <= cubeZ + 1; z++) {
            for (int y = cubeY - 1; y <= cubeY + 1; y++) {
                for (int x = cubeX - 1; x <= cubeX + 1; x++) {
                    if (x != cubeX || y != cubeY || z != cubeZ) {
                        adjacentCubes.add(getCube(x, y, z));
                    }
                }
            }
        }
        return adjacentCubes;
    }

    public int countActiveAdjacentCubes(int cubeX, int cubeY, int cubeZ) {
        return (int) adjacentCubes(cubeX, cubeY, cubeZ).stream().filter(b -> b).count();
    }

    public long countActiveCubes() {
        return cubes.values().stream().flatMap(m -> m.values().stream()).flatMap(Collection::stream).count();
    }

    public String getCubesAtLayer(int z) {
        StringBuilder sb = new StringBuilder();

        for (int y = -bootSequence; y < initDimension + bootSequence; y++) {
            for (int x = -bootSequence; x < initDimension + bootSequence; x++) {
                sb.append(getCube(x, y, z) ? '#' : '.');
            }
            sb.append("\n");
        }

        return sb.toString();
    }

    public void boot() {
        for (int round = 0; round < 6; round++) {
            Map<Integer, Map<Integer, Set<Integer>>> newCubeStates = new HashMap<>();

            for (int z = -1 - bootSequence; z <= 2 + bootSequence; z++) {
                for (int y = -1 - bootSequence; y <= initDimension + bootSequence + 1; y++) {
                    for (int x = -1 - bootSequence; x <= initDimension + bootSequence + 1; x++) {
                        var isActive = getCube(x, y, z);
                        var activeAdjacentCount = countActiveAdjacentCubes(x, y, z);
                        if (isActive) {
                            setCube(newCubeStates, x, y, z, activeAdjacentCount == 2 || activeAdjacentCount == 3);
                        } else {
                            setCube(newCubeStates, x, y, z, activeAdjacentCount == 3);
                        }
                    }
                }
            }
            this.cubes = newCubeStates;
            this.bootSequence++;
        }
    }


}
