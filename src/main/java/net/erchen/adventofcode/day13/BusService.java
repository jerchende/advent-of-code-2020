package net.erchen.adventofcode.day13;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;
import static net.erchen.adventofcode.common.MathFunctions.extendedEuclideanAlgorithm;

public class BusService {

    public static long part1(int earliestTimestamp, String[] busRoutes) {
        return Stream.of(busRoutes)
                .filter(s -> !"x".equals(s))
                .map(route -> new BusRoute(Integer.parseInt(route), 0))
                .min(comparing(busRoute -> busRoute.nextDepartment(earliestTimestamp)))
                .map(route -> route.nextDepartment(earliestTimestamp) * route.getRoute())
                .orElseThrow();

    }

    public static long part2(String[] busRoutes) {
        AtomicInteger offset = new AtomicInteger(-1);
        var routes = Stream.of(busRoutes)
                .peek(x -> offset.incrementAndGet())
                .filter(s -> !"x".equals(s))
                .map(route -> new BusRoute(Integer.parseInt(route), offset.get()))
                .collect(toList());

        long product = routes.stream().mapToLong(BusRoute::getRoute).reduce((a, b) -> a * b).orElse(0);

        return Math.floorMod(routes.stream().reduce(0L, (sum, route) -> {
            var d = product / route.getRoute();
            var extendedEuclideanAlgorithm = extendedEuclideanAlgorithm(d, route.getRoute());
            var delay = route.getRoute() - route.getOffset();

            return sum + delay * d * extendedEuclideanAlgorithm[1];
        }, Long::sum), product);

    }

}
