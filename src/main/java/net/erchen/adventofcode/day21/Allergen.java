package net.erchen.adventofcode.day21;

public record Allergen(String allergen) implements Comparable<Allergen> {

    @Override
    public int compareTo(Allergen o) {
        return this.allergen().compareTo(o.allergen());
    }
}
